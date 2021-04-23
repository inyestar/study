package com.inminhouse.study.spring.ch05.factory;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch05/factory/application-context.xml");
		DataCollector c1 = ctx.getBean("collector1", DataCollector.class);
		DataCollector c2 = ctx.getBean("collector2", DataCollector.class);
		System.out.println("collector1.thrshold=" + c1.getThreshold());
		System.out.println("collector2.thrshold=" + c2.getThreshold());
		ctx.close();
	}

}
