package org.zerock.test;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardServiceTest {
	
	@Inject
	BoardService service;
	
	@After
	public void testRead()throws Exception {
		service.read(1);
	}
	
	@Test
	public void testModify()throws Exception {
		
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("서비스 수정");
		board.setContent("서비스 수정");
		service.modify(board);;
	}

}
