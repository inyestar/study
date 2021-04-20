package com.inminhouse.study.spring.ch04;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MainByJavaConfig {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		ConfigurableEnvironment env = ctx.getEnvironment();
		String dbUser = env.getProperty("db.user");
		
		ConnectionProviderImpl providerImpl = ctx.getBean("connectionProviderImpl", ConnectionProviderImpl.class);
		ConnectionProvider provider = ctx.getBean("connectionProvider", ConnectionProvider.class);
		System.out.println(providerImpl);
		System.out.println(provider);
		ctx.close();
	}

}
