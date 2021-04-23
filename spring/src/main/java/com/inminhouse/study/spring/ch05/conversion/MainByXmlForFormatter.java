package com.inminhouse.study.spring.ch05.conversion;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.inminhouse.study.spring.ch05.property.InvestmentSimulator;

public class MainByXmlForFormatter {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch05/conversion/application-context-formatter.xml");
		InvestmentSimulator simulator = ctx.getBean("simulator", InvestmentSimulator.class);
		System.out.println(simulator.getMinimumAmount());
		RestClient restClient = ctx.getBean("restClient", RestClient.class);
		System.out.printf("apiDate=%s, type=%s%n", restClient.getApiDate(), restClient.getApiDate().getClass());
		ctx.close();
	}
}
