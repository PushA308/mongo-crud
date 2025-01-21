package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CrudDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ar = SpringApplication.run(CrudDemoApplication.class, args);
		System.out.println(ar.getBeanDefinitionNames().toString());
	}

}
