package com.inminhouse.study.spring.ch09.jsonxml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// jaxb2 api는 자바 6이후부터 기본으로 포함됨
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message-list") // 루트 태그가 message-list인 xml이 생성됨
public class GuestMessageList {

	@XmlElement(name = "message")
	private List<GuestMessage> messages;
	
	public GuestMessageList() {

	}
	
	public GuestMessageList(List<GuestMessage> messages) {
		this.messages = messages;
	}
	
	public List<GuestMessage> getMessages() {
		return messages;
	}
}
