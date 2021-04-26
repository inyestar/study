package com.inminhouse.study.spring.ch06.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inminhouse.study.spring.ch06.pojo.ReadableArticleService;
import com.inminhouse.study.spring.ch06.quickstart.NewArticleRequest;
import com.inminhouse.study.spring.ch06.quickstart.WritableArticleService;
import com.inminhouse.study.spring.ch06.quickstart.WritableArticleServiceImpl;

public class MainByJavaConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		WritableArticleService wService = ctx.getBean("writableArticleService", WritableArticleService.class);
		
		System.out.println(wService instanceof WritableArticleService);
		// (advice가 적용된) 인터페이스를 구현한 빈 객체의 프록시 객체는 인터페이스 타입으로 생성되기때문에 아래 결과는 false
		// 따라서 다른 빈 객체에서 아래 프록시 객체를 구현체인 WritableArticleServiceImpl 로 참조하고 있을 경우 익셉션 발생
		System.out.println(wService instanceof WritableArticleServiceImpl);
		System.out.println(wService.getClass().getName());
		
		/*
		 * 스프링 컨테이너랑 AOP 프록시랑 달라서 로그를 보면 AOP 전체 로깅이 찍히기전에 컨테이너가 종료되는 것을 확인할 수 있음
		 */
		wService.write(new NewArticleRequest("writer", "title", "content"));
		wService.write(new NewArticleRequest("writer1", "title1", "content1"));
		wService.write(new NewArticleRequest("writer2", "title2", "content2"));
		
		ReadableArticleService rService = ctx.getBean("readableArticleService", ReadableArticleService.class);
		rService.read(1);
		rService.read(1);
		ctx.close();
	}
}
