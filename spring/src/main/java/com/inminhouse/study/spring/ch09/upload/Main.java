package com.inminhouse.study.spring.ch09.upload;

import java.util.Map;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		Properties props = System.getProperties();
		for(Map.Entry<Object, Object> pro : props.entrySet()) {
			System.out.println(pro);
		}
	}

}
