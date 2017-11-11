package org.zerock.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {

	@Inject
	BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test @Ignore
	public void testCreat() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("새로운 글입니다");
		vo.setContent("새로운 글입니다");
		vo.setWriter("user00");
		
		dao.create(vo);
	}
	
	@Test @Ignore
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}
	
	@Test @Ignore
	public void testUpdate()throws Exception {
		
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo.setTitle("수정한 글입니다");
		vo.setContent("수정한 글입니다");
		vo.setWriter("user00");
		
		dao.update(vo);
	}
	
	@Test @Ignore
	public void testDelete()throws Exception {
		dao.delete(2);
	}
	
	@Test @Ignore
	public void testListPage()throws Exception {
		int page = 3;
		
		List<BoardVO> list = dao.listPage(page); 
		
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+" : "+boardVO.getTitle());
		}
	}
	
	@Test @Ignore
	public void testListCriteria()throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(3);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for (BoardVO vo : list) {
			logger.info("BNO="+vo.getBno()+", Title="+vo.getTitle());
		}
	}
	
	@Test @Ignore
	public void testUri() {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/board/listPage")
				.queryParam("page", 7)
				.queryParam("perPageNum", 20)
				.build();
		
		logger.info(uriComponents.toString());
	}
	
	@Test @Ignore
	public void testUri2() {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/{module}/{page}")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build()
				.expand("board", "read")
				.encode();
		logger.info(uriComponents.toString());
	}
	
	@Test
	public void testDynamic1()throws Exception {
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setSearchType("tc");
		cri.setKeyword("내용");
		
		logger.info("======================================");
		List<BoardVO> list = dao.listSearchCriteria(cri);
		
		logger.info("======================================");
		logger.info("Count : " + dao.listSearchCount(cri));
	}
}
