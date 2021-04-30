package com.inminhouse.study.spring.ch09.jsonxml;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class XmlController {

	@RequestMapping(value = "/get/xml")
	@ResponseBody 
	// Jaxb2RootElementHttpMessageConverter가 사용됨
	// response 헤더의 Content-Type: application/xhtml+xml
	public GuestMessageList getList() {
		return new GuestMessageList(Arrays.asList(
				new GuestMessage(1, "메시지1", new Date()),
				new GuestMessage(2, "메시지2", new Date()),
				new GuestMessage(3, "메시지3", new Date())
				));
	}
	
	@RequestMapping(value = "/put/xml")
	@ResponseBody
	public GuestMessageList putList(@RequestBody GuestMessageList messagesList) {
		return new GuestMessageList(messagesList.getMessages().stream().limit(1).collect(Collectors.toList()));
	}
	
}
