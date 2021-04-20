package com.inminhouse.study.spring.ch04;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class ConnectionProviderImpl implements EnvironmentAware {
	
	private Environment env;
	private String dirver;
	private String user;
	private String password;
	private String url;

	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;
	}
	
	public void init() {
		System.out.println("ConnectionProviderImpl.init()");
		dirver = env.getProperty("db.driver");
		user = env.getProperty("db.user");
		password = env.getProperty("db.password");
		url = env.getProperty("db.url");
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
