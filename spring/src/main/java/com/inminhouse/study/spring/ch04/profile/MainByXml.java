package com.inminhouse.study.spring.ch04.profile;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		// 생성자 파라미터로 xml을 전달할 경우 refresh를 이미 해서 다시 할 수 없음
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		getDevProfile(ctx);
//		getProdProfile(ctx);
		ctx.close();
	}

	private static void getDevProfile(GenericXmlApplicationContext ctx) {
		System.out.println("=========================================== DEV =======================================");
		ctx.getEnvironment().setActiveProfiles("dev");
		ctx.load("classpath:/ch04/profile/application-context.xml", "classpath:/ch04/profile/datasource-dev.xml", "classpath:/ch04/profile/datasource-prod.xml");
		ctx.refresh();
		
		JdbcConnectionProvider conn = ctx.getBean("jdbcConnectionProvider", JdbcConnectionProvider.class);
//		JndiConnectionProvider conn2 = ctx.getBean("jndiConnectionProvider", JndiConnectionProvider.class); throws NoSuchBeanDefinitionException
		System.out.println(conn);
	}
	
	private static void getProdProfile(GenericXmlApplicationContext ctx) {
		System.out.println("=========================================== PROD =======================================");
		ctx.getEnvironment().setActiveProfiles("prod");
		ctx.load("classpath:/ch04/profile/app-config.xml", "classpath:/ch04/profile/datasource-dev.xml", "classpath:/ch04/profile/datasource-prod.xml");
		ctx.refresh();
		
		JndiConnectionProvider conn = ctx.getBean("jndiConnectionProvider", JndiConnectionProvider.class);
		System.out.println(conn);
	}
}
