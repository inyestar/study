package com.inminhouse.study.spring.ch04;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class Main {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		/*
		 * 아래 JAVA_HOME 프로퍼티를 읽어오는 순서
		 * 1. 시스템 프로퍼티 PropertySource
		 *    ㄴ System.setProperty()나 java 커맨드에 -D 옵션으로 추가한 값
		 * 2. 환경 변수 PropertySource >> 여기서 리턴
		 * 3. 자바 Properties PropertySource
		 * 4. JNDI PropertySource
		 */
		String javaHome = env.getProperty("JAVA_HOME");
		String javaVersion = env.getProperty("java.version");
		System.out.printf("JAVA_HOME=%s, java.version=%s%n", javaHome, javaVersion);
		
		/*
		 * 스프링은 기본적으로 시스템 프로퍼티와 환경 변수만 Enviroment의 프로퍼티로 사용하므로 
		 * db.properties에 대한 등록이 따로 필요
		 */
		MutablePropertySources propertySources = env.getPropertySources();
		try {
			// addLast()로 등록하면 가장 마지막에 PropertySource로 등록되어서 우선순위가 가장 낮다. 
			// addFirst()의 경우 가장 먼저 등록되며 우선순위가 가장 높다.
			propertySources.addLast(new ResourcePropertySource("classpath:/ch04/db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String dbUser = env.getProperty("db.user");
		System.out.println(dbUser);
		
		ctx.close();
	}

}
