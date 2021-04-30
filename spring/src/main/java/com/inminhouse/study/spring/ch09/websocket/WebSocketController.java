package com.inminhouse.study.spring.ch09.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {
	
	@RequestMapping(value = "/websocket/echo")
	public String echo() {
		return "websocket/echo";
	}
	
	@RequestMapping(value = "/websocket/chat")
	public String chat() {
		return "websocket/chat";
	}
}
