package com.inminhouse.study.spring.ch03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch03/application-context.xml");
		System.out.println("================ XmlApplicationContext ===============");
		ctx.close();
	}
}
