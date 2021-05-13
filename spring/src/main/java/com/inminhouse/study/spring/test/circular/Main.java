package com.inminhouse.study.spring.test.circular;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		BeanA a = ctx.getBean(BeanA.class);
		BeanB b = ctx.getBean(BeanB.class);
		BeanC c = ctx.getBean(BeanC.class);
		
		a.test();
		b.test();
		c.test();
		
		ctx.close();

	}

}
