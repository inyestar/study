package com.inminhouse.study.spring.test.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

	@Autowired private BeanC c;
	
//	@Autowired 
//	public BeanB(BeanC c) {
//		this.c = c;
//	}
	
	public void test() {
		c.print();
	}
	
	public void print() {
		System.out.println("this is class B");
	}
}
