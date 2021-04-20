package com.inminhouse.study.spring.ch04.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJavaConfig {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("dev");
		ctx.register(DatasourceConfigDev.class, DatasourceConfigProd.class);
		ctx.refresh();
		
//		JndiConnectionProvider conn = ctx.getBean("connProvider", JndiConnectionProvider.class);
		JdbcConnectionProvider conn = ctx.getBean("connProvider", JdbcConnectionProvider.class);
		System.out.println(conn);
		
		ctx.close();
	}

}
