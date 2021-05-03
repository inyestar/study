package com.inminhouse.study.spring.ch11.pool;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch11/pool/application-context.xml");
		ctx.close();
	}

}
