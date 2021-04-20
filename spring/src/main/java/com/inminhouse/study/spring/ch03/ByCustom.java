package com.inminhouse.study.spring.ch03;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ByCustom implements ApplicationContextAware, BeanNameAware{

	public void init() {
		System.out.printf("ByCustom.init() -------- initializing!!%n");
	}
	
	public void destroy() {
		System.out.printf("ByCustom.destroy() -------- destroying!!%n");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.printf("Gettting [%s] in %s%n", applicationContext.getClass().getSimpleName(), this.getClass().getName());
	}

	@Override
	public void setBeanName(String name) {
		System.out.printf("Gettting its name [%s] in %s%n", name, this.getClass().getName());
	}
}
