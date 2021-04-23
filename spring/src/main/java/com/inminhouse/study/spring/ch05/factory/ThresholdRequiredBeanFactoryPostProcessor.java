package com.inminhouse.study.spring.ch05.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class ThresholdRequiredBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private int defaultThreshold;

	public void setDefaultThreshold(int defaultThreshold) {
		this.defaultThreshold = defaultThreshold;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		for(String name : beanNames) {
			BeanDefinition beanDef = beanFactory.getBeanDefinition(name);
			Class<?> clazz = null;
			if(beanDef.getBeanClassName() != null) {
				try {
					clazz = Class.forName(beanDef.getBeanClassName());
				} catch (ClassNotFoundException e) {
					throw new FatalBeanException(e.getMessage(), e);
				}
				/*
				 * ThresholdRequired.class.isAssignableFrom 로
				 * 빈의 클래스 타입이 ThresholdRequired 인터페이스를 구현했는지 검사
				 */
				if(clazz != null && ThresholdRequired.class.isAssignableFrom(clazz)) {
					MutablePropertyValues prop = beanDef.getPropertyValues();
					if(!prop.contains("threshold")) {
						prop.add("threshold", defaultThreshold);
					}
				}
			}
		}
	}
}