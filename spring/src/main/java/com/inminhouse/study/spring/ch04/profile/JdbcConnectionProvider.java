package com.inminhouse.study.spring.ch04.profile;

public class JdbcConnectionProvider {
	private String dirver;
	private String user;
	private String password;
	private String url;
	
	public void init() {
		System.out.println("JdbcConnectionProvider.init()");
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
