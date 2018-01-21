package org.zerock.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

public class AuthInterceptor extends HandlerInterceptorAdapter {

  private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

  @Inject
  private UserService service;
  
  @Override
  public boolean preHandle(HttpServletRequest request,
      HttpServletResponse response, Object handler) throws Exception {
    
    HttpSession session = request.getSession();   
    
    if(session.getAttribute("login") == null){
        
        logger.info("current user is not logined");
        
        saveDest(request); // 리다이렉트를 위하여 접속을 원하는 URI를 저장
        
        Cookie loginCookie = WebUtils.getCookie(request, "loginCookie"); // loginCookie를 가져옵니다.
        
        if(loginCookie != null) { 
          
          UserVO userVO = service.checkLoginBefore(loginCookie.getValue()); // DB에 저장되어있는 계정정보를 쿠키ID로 가져온다. 
          
          logger.info("USERVO: " + userVO);
          
          if(userVO != null){
            session.setAttribute("login", userVO);
            return true;
          }
          
        }

        response.sendRedirect("/user/login"); // HttpSession, loginCookie 둘다 없으면 로그인 페이지로 이동
        return false;
      }
    return true;
  }
  
  private void saveDest(HttpServletRequest req) {

	    String uri = req.getRequestURI();

	    String query = req.getQueryString();

	    if (query == null || query.equals("null")) {
	      query = "";
	    } else {
	      query = "?" + query;
	    }

	    if (req.getMethod().equals("GET")) {
	      logger.info("dest URI: " + (uri + query));
	      req.getSession().setAttribute("dest", uri + query);
	    }
  }
}
