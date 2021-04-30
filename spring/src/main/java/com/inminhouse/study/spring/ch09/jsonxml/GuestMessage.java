package com.inminhouse.study.spring.ch09.jsonxml;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"id", "message", "creationTime"})
public class GuestMessage {
	
	private int id;
	private String message;
	private Date creationTime;
	
	/*
	 * jaxb2가 xml을 바인딩할 때 args가 없는 생성자 필요
	 */
	public GuestMessage() {
		
	}
	
	public GuestMessage(int id, String message, Date creationTime) {
		this.id = id;
		this.message = message;
		this.creationTime = creationTime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	
	
}
