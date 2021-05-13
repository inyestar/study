package com.inminhouse.study.spring.test.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanA {

	@Autowired private BeanB b;
	
//	@Autowired
//	public BeanA(BeanB b) {
//		this.b = b;
//	}
	
	public void test() {
		b.print();
	}
	
	public void print() {
		System.out.println("this is class A");
	}
}
