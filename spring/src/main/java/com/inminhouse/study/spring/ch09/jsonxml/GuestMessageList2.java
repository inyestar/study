package com.inminhouse.study.spring.ch09.jsonxml;

import java.util.List;

public class GuestMessageList2 {

	private List<GuestMessage> messages;
	
	public GuestMessageList2() {

	}
	
	public GuestMessageList2(List<GuestMessage> messages) {
		this.messages = messages;
	}
	
	public List<GuestMessage> getMessages() {
		return messages;
	}
}
