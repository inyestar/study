package com.inminhouse.study.spring.ch04.placeholder;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJavaConfig {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		ConnectionProvider  connection = ctx.getBean("connection", ConnectionProvider.class);
		System.out.println(connection);
		ctx.close();
	}

}
