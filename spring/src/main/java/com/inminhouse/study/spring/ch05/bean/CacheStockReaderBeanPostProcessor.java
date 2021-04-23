package com.inminhouse.study.spring.ch05.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class CacheStockReaderBeanPostProcessor implements BeanPostProcessor, Ordered{
	
	private int order;
	

	@Override
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
	/**
	 * 기존 StockReaderImpl 코드를 변경하지 않고서 
	 * CacheStockReader 객체를 사용하도록 하는 메소드
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(StockReader.class.isAssignableFrom(bean.getClass())) {
			return new CacheStockReader((StockReader) bean);
		}
		return bean;
	}

}
