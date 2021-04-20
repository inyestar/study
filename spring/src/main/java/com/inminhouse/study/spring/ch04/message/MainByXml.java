package com.inminhouse.study.spring.ch04.message;

import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch04/message/application-context.xml");
		String[] arg = new String[] {"Inyestar"};
		System.out.println(ctx.getMessage("hello", arg, Locale.getDefault()));
		System.out.println(ctx.getMessage("hello", arg, Locale.ENGLISH));
		ctx.close();
	}

}
