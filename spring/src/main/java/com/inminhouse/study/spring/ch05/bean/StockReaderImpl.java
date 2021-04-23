package com.inminhouse.study.spring.ch05.bean;

import java.util.Date;

public class StockReaderImpl implements StockReader{

	@Override
	public int getClosePrice(Date date, String code) {
		System.out.println("StockReaderImpl: " + code);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// do nothing
		}
		
		return 500;
	}

}
