package com.inminhouse.study.spring.ch04.placeholder;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainByXml {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch04/placeholder/application-context.xml");
		ConnectionProvider connectionProvider = ctx.getBean("connectionProvider", ConnectionProvider.class);
		System.out.println(connectionProvider);
		ctx.close();
	}

}
