package com.inminhouse.study.spring.ch05.factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJavaConfig {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		DataCollector c1 = ctx.getBean("collector1", DataCollector.class);
		DataCollector c2 = ctx.getBean("collector2", DataCollector.class);
		System.out.println("collector1.thrshold=" + c1.getThreshold());
		/*
		 *  @Configuration으로 생성되는 빈 객체는 빈 설정 정보를 만들지 않기 떄문에
		 *  BeanFactoryPostProcessor를 구현한 클래스를 이용하더라도 프로퍼티 값이 변경되지 않는다.
		 */
		System.out.println("collector2.thrshold=" + c2.getThreshold());
		ctx.close();
	}

}
