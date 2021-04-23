package com.inminhouse.study.spring.ch05.property;

import java.net.URL;
import java.util.Date;

public class RestClient {

	private URL serviceUrl;
	
	private Date apiDate;

	public URL getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(URL serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public Date getApiDate() {
		return apiDate;
	}

	public void setApiDate(Date apiDate) {
		this.apiDate = apiDate;
	}
	
	
}
