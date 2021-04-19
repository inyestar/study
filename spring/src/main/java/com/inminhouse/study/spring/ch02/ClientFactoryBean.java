package com.inminhouse.study.spring.ch02;

import org.springframework.beans.factory.FactoryBean;

public class ClientFactoryBean implements FactoryBean<ClientFactoryBean> {
	
	private ClientFactoryBean clientFactoryBean;
	private String server;
	private int port;
	private String contentType;
	private String encoding;
	
	/**
	 * 실제 스프링 비으로 사용될 객체를 리턴하는 메소드
	 */
	@Override
	public ClientFactoryBean getObject() throws Exception {
		
		if(clientFactoryBean != null) {
			return this.clientFactoryBean;
		}
		
		ClientFactoryBean bean = new ClientFactoryBean();
		bean.setServer(server);
		bean.setPort(port);
		bean.setContentType(contentType);
		bean.setEncoding(encoding);
		bean.init();
		this.clientFactoryBean =  bean;
		return this.clientFactoryBean;
	}

	/**
	 * 빈 객체의 타입 리턴
	 */
	@Override
	public Class<?> getObjectType() {
		return ClientFactoryBean.class;
	}

	/**
	 * 매번 동일한 객체를 리턴하므로 true
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	private void init() {
		System.out.printf("ClientFactory.init() [server=%s, port=%d, content-type=%s, encoding=%s]%n",
				server,
				port,
				contentType,
				encoding);
	}
	
}
