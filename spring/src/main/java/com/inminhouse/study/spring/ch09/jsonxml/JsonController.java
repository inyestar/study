package com.inminhouse.study.spring.ch09.jsonxml;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {


	@RequestMapping(value = "/get/json")
	@ResponseBody 
	// MappingJackson2HttpMessageConverter가 사용됨
	// response 헤더의 Content-Type: application/json;charset=utf-8
	public GuestMessageList2 getList() {
		return new GuestMessageList2(Arrays.asList(
				new GuestMessage(1, "메시지1", new Date()),
				new GuestMessage(2, "메시지2", new Date()),
				new GuestMessage(3, "메시지3", new Date())
				));
	}
	
	@RequestMapping(value = "/put/json")
	@ResponseBody
	public GuestMessageList2 putList(@RequestBody GuestMessageList messagesList) {
		return new GuestMessageList2(messagesList.getMessages().stream().limit(1).collect(Collectors.toList()));
	}
}
