package com.inminhouse.study.spring.ch05.bean;

import java.util.Date;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch05/bean/application-context.xml");
		/*
		 * BeanPostProcessor에 의해 stockReader 빈은 CacheStockReader로 교체되었기떄문에
		 * 아래 bean의 타입을 StockReaderImpl로 변경하면 존재하지 않는다는 익셉션이 발생함
		 */
		StockReader sotkcReader = ctx.getBean("stockReader", StockReader.class);
//		StockReaderImpl sotkcReader = ctx.getBean("stockReader", StockReaderImpl.class);
		Date date = new Date();
		printClosePrice(sotkcReader, date, "0000");
		printClosePrice(sotkcReader, date, "0000");
		ctx.close();
	}
	
	private static void printClosePrice(StockReader reader, Date date, String code) {
		long before = System.currentTimeMillis();
		int price = reader.getClosePrice(date, code);
		long after = System.currentTimeMillis();
		System.out.printf("price=%d, elapsed=%d%n", price, after-before);
	}
}
