package org.zerock;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

public class MemberMapperTest extends App2ApplicationTests{

	@Autowired
	private MemberMapper mapper;
	
	@Ignore
	@Test
	public void testInsert() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setUserid("user99");
		vo.setUserpw("user99");
		vo.setUsername("LeeHyunKeun");
		vo.setEmail("user99@member.com");
		mapper.create(vo);
	}
	
	@Test
	public void testLogin() throws Exception {
		MemberVO vo = mapper.login("user99", "user99");
		System.out.println(vo);
	}
}
