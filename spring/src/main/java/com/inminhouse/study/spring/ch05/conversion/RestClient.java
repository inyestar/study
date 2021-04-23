package com.inminhouse.study.spring.ch05.conversion;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RestClient {

	private Date apiDate;

	public Date getApiDate() {
		return apiDate;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public void setApiDate(Date apiDate) {
		this.apiDate = apiDate;
	}
	
	
}
