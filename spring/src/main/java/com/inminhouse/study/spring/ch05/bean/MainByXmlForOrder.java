package com.inminhouse.study.spring.ch05.bean;

import java.util.Date;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXmlForOrder {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch05/bean/application-context.xml");
		StockReader stockReader = ctx.getBean("stockReader", StockReader.class);
		System.out.println("stockReader = " + stockReader.getClass().getName());
		Date date = new Date();
		int value1 = stockReader.getClosePrice(date, "0000");
		int value2 = stockReader.getClosePrice(date, "0000");
		ctx.close();
		
	}
	
}
