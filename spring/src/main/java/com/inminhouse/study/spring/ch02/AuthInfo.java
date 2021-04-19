package com.inminhouse.study.spring.ch02;

public class AuthInfo {
	
	private String id;
	
	public AuthInfo(String id) {
		this.id = id;
		System.out.printf("AuthInfo [id=%s] authenticated\n", id);
	}

}
