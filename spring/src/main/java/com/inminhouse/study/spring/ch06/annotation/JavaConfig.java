package com.inminhouse.study.spring.ch06.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.inminhouse.study.spring.ch06.pojo.ReadableArticleService;
import com.inminhouse.study.spring.ch06.pojo.ReadableArticleServiceImpl;
import com.inminhouse.study.spring.ch06.quickstart.ArticleDao;
import com.inminhouse.study.spring.ch06.quickstart.MemoryArticleDao;
import com.inminhouse.study.spring.ch06.quickstart.WritableArticleService;
import com.inminhouse.study.spring.ch06.quickstart.WritableArticleServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {

	@Bean
	public ProfilingAspect traceAsepct() {
		return new ProfilingAspect();
	}
	
	@Bean
	public ArticleCacheAspect cacheAspect() {
		return new ArticleCacheAspect();
	}
	
	/*
	 * ProfilingAspect에 구현한 Advice가 아래 객체에 적용될 경우 
	 * 스프링은 아래 객체에 대한 프록시 객체를 사용하여 원본 객체 대신 사용한다.
	 * 변환된 코드는 아래와 같다.
	 * (!) bean 객체가 인터페이스를 구현하고 있어 인터페이스를 반환하도록 생성됨
	 * @Bean
	 * public WritableArticleService writableArticleService (){
	 * 		ProxyFactory factory = new ProxyFactory(writableServiceOriginal());
	 * 		...
	 * 		return (WritableArticleService) factory.getFactory();
	 * }
	 * 
	 * public WritableArticleService writableServiceOriginal() {
	 * 		return new WritableArticleServiceImpl(articleDao());
	 * }
	 */
	@Bean
	public WritableArticleService writableArticleService() {
		return new WritableArticleServiceImpl(articleDao());
	}
	
	@Bean
	public ReadableArticleService readableArticleService() {
		ReadableArticleServiceImpl rService = new ReadableArticleServiceImpl();
		rService.setArticleDao(articleDao());
		return rService;
	}
	
	@Bean
	public ArticleDao articleDao() {
		return new MemoryArticleDao();
	}
}

