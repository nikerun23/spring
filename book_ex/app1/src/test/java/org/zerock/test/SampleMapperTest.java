package org.zerock.test;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.persistence.SampleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class SampleMapperTest {

	@Inject
	private SampleMapper mapper;
	
	@Inject
	private final static Logger logger = LoggerFactory.getLogger(SampleMapperTest.class);
	
	@Ignore
	@Test
	public void testTime() {
		logger.info("------- getName() : "+mapper.getClass().getName());
		logger.info("------- getTime() : "+mapper.getTime());
	}
	
	@Ignore
	@Test
	public void testMail() {
		String email = mapper.getEmail("user00", "user00");
		logger.info(email);
	}
	
	@Test
	public void testUserName() {
		String name = mapper.getUserName("user00", "user00");
		logger.info(name);
	}
}
