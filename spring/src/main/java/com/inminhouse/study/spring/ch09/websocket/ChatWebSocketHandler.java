package com.inminhouse.study.spring.ch09.websocket;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocketHandler extends TextWebSocketHandler{
	
	private Map<String, WebSocketSession> users = new ConcurrentHashMap<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log(session.getId(), "연결 됨");
		users.put(session.getId(), session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log(session.getId(), "연결 종료됨");
		users.remove(session.getId());
	}
	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log(session.getId(), "[수신] " + message.getPayload());
		for(WebSocketSession s : users.values()) {
			s.sendMessage(message);
			log(s.getId(), "[발송] " + message.getPayload());
		}
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log(session.getId(), "[에러] " + exception.getMessage());
	}
	
	private void log(String sessionId, String msg) {
		System.out.printf("[%s][%s] %s%n", new Date(), sessionId, msg);
	}
}
