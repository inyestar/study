package com.inminhouse.study.spring.ch05.conversion;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.inminhouse.study.spring.ch05.property.InvestmentSimulator;

public class MainByXml {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch05/conversion/application-context.xml");
		InvestmentSimulator simulator = ctx.getBean("simulator", InvestmentSimulator.class);
		System.out.println(simulator.getMinimumAmount());
		ctx.close();
	}
}
