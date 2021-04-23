package com.inminhouse.study.spring.ch05.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public static ThresholdRequiredBeanFactoryPostProcessor processor() {
		ThresholdRequiredBeanFactoryPostProcessor p = new ThresholdRequiredBeanFactoryPostProcessor();
		p.setDefaultThreshold(10);
		return p;
	}
	
	@Bean
	public DataCollector collector1() {
		DataCollector c = new DataCollector();
		c.setThreshold(5);
		return c;
	}
	
	@Bean
	public DataCollector collector2() {
		return new DataCollector();
	}
}
