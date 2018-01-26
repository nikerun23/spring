package org.zerock.test;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.persistence.SampleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class SampleMapperTest {

	@Inject
	private SampleMapper mapper;
	
	@Ignore
	@Test
	public void testTime() {
		System.out.println("------- getName() : "+mapper.getClass().getName());
		System.out.println("------- getTime() : "+mapper.getTime());
	}
	
	@Test
	public void testMail() {
		String email = mapper.getEmail("user00", "user00");
		System.out.println("------- Email : " + email);
	}
}
