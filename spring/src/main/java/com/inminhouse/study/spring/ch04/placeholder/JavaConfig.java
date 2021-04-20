package com.inminhouse.study.spring.ch04.placeholder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class JavaConfig {
	
	/*
	 * BeanFactoryPostProcessor 인터페이스를 구현한 객체
	 * 스프링은 설정 정보를 읽은뒤에 BeanFactoryPostProcessor를 구현한 객체가 있으면 그 객체를 먼저 생성
	 * 정적 메소드(static)으로 구현해야함
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setLocation(new ClassPathResource("/ch04/db.properties"));
		return configurer;
	}
	
	@Bean(initMethod = "init")
	public ConnectionProvider connection() {
		return new ConnectionProvider();
	}
}
