package com.inminhouse.study.spring.ch03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public ByInterface byInterface() {
		return new ByInterface();
	}
	

	@Bean
	public ByAnnotation byAnnotation() {
		return new ByAnnotation();
	}
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public ByCustom byCustom() {
		return new ByCustom();
	}
	
}
