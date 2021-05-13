package com.inminhouse.study.spring.test.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanC {

	@Autowired private BeanA a;
	
//	 @Autowired
//	public BeanC(BeanA a) {
//		this.a = a;
//	}
	public void test() {
		a.print();
	}
	
	
	public void print() {
		System.out.println("this is class C");
	}
}
