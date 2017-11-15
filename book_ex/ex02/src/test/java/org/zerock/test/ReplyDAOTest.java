package org.zerock.test;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;
import org.zerock.persistence.ReplyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ReplyDAOTest {

	@Inject
	ReplyDAO dao;
	
	@Test @Ignore
	public void testCreate() throws Exception {
		
		ReplyVO vo = new ReplyVO();
		
		vo.setReplytext("TEST");
		vo.setReplyer("LEE");
		vo.setBno(7);
		dao.create(vo);
		
		assertEquals(1, dao.list(7).size());
	}
	
}
