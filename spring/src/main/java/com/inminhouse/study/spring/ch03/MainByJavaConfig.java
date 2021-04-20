package com.inminhouse.study.spring.ch03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJavaConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		System.out.println("================ AnnotationApplicationContext ===============");
		ctx.close();
	}

}
