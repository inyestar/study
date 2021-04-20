package com.inminhouse.study.spring.ch03;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ByInterface implements InitializingBean, DisposableBean{

	@Override
	public void destroy() throws Exception {
		System.out.printf("ByInterface.destroy() -------- destroying!!%n");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.printf("ByInterface.afterPropertiesSet() -------- initializing!!%n");
	}

}
