package org.zerock.test;

import javax.inject.Inject;

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
	
	@Test
	public void testTime() {
		System.out.println("------- getName() : "+mapper.getClass().getName());
		System.out.println("------- getTime() : "+mapper.getTime());
	}
}
