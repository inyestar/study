package com.inminhouse.study.spring.ch06.quickstart;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch06/quickstart/application-context.xml");
		WritableArticleService wService = ctx.getBean("writableArticleService", WritableArticleService.class);
		/*
		 * 스프링 컨테이너랑 AOP 프록시랑 달라서 로그를 보면 AOP 전체 로깅이 찍히기전에 컨테이너가 종료되는 것을 확인할 수 있음
		 */
		wService.write(new NewArticleRequest("writer", "title", "content"));
		wService.write(new NewArticleRequest("writer1", "title1", "content1"));
		wService.write(new NewArticleRequest("writer2", "title2", "content2"));
		ctx.close();
	}
}
