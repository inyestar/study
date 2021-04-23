package com.inminhouse.study.spring.ch05.bean;

import java.util.Date;

public interface StockReader {
	public int getClosePrice(Date date, String code);
}
