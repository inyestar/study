package com.inminhouse.study.spring.ch02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForAnnotationTest {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch02/application-context.xml");
		OrderService ordSvc = ctx.getBean("orderService", OrderService.class);
		ordSvc.print();
		ctx.close();
	}

}
