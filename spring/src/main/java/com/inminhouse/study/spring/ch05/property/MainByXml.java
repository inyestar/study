package com.inminhouse.study.spring.ch05.property;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch05/property/application-context.xml");
		InvestmentSimulator simulator = ctx.getBean("simulator", InvestmentSimulator.class);
		System.out.println(simulator.getMinimumAmount());
		RestClient restClient = ctx.getBean("restClient", RestClient.class);
		System.out.printf("serviceUrl=%s, type=%s%n", restClient.getServiceUrl(), restClient.getServiceUrl().getClass());
		System.out.printf("apiDate=%s, type=%s%n", restClient.getApiDate(), restClient.getApiDate().getClass());
		ctx.close();
	}
}
