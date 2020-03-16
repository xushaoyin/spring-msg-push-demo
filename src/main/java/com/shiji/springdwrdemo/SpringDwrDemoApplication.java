package com.shiji.springdwrdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:spring/spring.xml")
public class SpringDwrDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDwrDemoApplication.class, args);
	}

}
