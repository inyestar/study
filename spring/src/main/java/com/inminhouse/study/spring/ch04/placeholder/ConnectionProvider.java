package com.inminhouse.study.spring.ch04.placeholder;

import org.springframework.beans.factory.annotation.Value;

public class ConnectionProvider {
	
	@Value("${db.driver}")
	private String dirver;
	@Value("${db.user}")
	private String user;
	@Value("${db.password}")
	private String password;
	@Value("${db.url}")
	private String url;
	
	public void init() {
		System.out.println("Connection.init()");
	}

	public void setDirver(String dirver) {
		this.dirver = dirver;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Database Connection in ")
				.append(this.getClass().getSimpleName()).append(" [")
				.append("dirver=").append(dirver).append(", ")
				.append("user=").append(user).append(", ")
				.append("password=").append(password).append(", ")
				.append("url=").append(url)
				.append("]").toString();
	}
}
