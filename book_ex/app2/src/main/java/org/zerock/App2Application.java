package org.zerock;


import javax.servlet.Filter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.zerock.filter.SampleFilter;

@SpringBootApplication
@MapperScan(value= {"org.zerock.mapper"})
public class App2Application {

	public static void main(String[] args) {
		SpringApplication.run(App2Application.class, args);
	}
	
	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(getFilter());
		registration.addUrlPatterns("/test/*");
		
		registration.setName("sampleFilter");
		return registration;
	}
	private Filter getFilter() {
		return new SampleFilter();
	}
}
