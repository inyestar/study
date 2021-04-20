package com.inminhouse.study.spring.ch03;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ByAnnotation {

	@PostConstruct
	public void init() {
		System.out.printf("ByAnnotation.init() -------- initializing!!%n");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.printf("ByAnnotation.destroy() -------- destroying!!%n");
	}
}
