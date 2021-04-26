package com.inminhouse.study.spring.ch06.pojo;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.inminhouse.study.spring.ch06.quickstart.NewArticleRequest;
import com.inminhouse.study.spring.ch06.quickstart.WritableArticleService;

public class MainByXml {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch06/pojo/application-context.xml", "classpath:/ch06/quickstart/application-context.xml");
		WritableArticleService wService = ctx.getBean("writableArticleService", WritableArticleService.class);
		wService.write(new NewArticleRequest("writer", "title", "content"));
		wService.write(new NewArticleRequest("writer1", "title1", "content1"));
		wService.write(new NewArticleRequest("writer2", "title2", "content2"));
		ReadableArticleService rService = ctx.getBean("readableArticleService", ReadableArticleService.class);
		rService.read(1);
		rService.read(1);
		ctx.close();
	}
}
