package org.zerock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value= {"org.zerock.mapper"})
public class App2Application {

	public static void main(String[] args) {
		SpringApplication.run(App2Application.class, args);
	}
}
