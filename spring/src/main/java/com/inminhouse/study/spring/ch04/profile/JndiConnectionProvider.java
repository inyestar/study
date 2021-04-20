package com.inminhouse.study.spring.ch04.profile;

public class JndiConnectionProvider {
	
	private String jndiName;
	
	public void init() {
		System.out.println("JndiConnectionProvider.init()");
	}
	
	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Database Connection in ")
				.append(this.getClass().getSimpleName()).append(" [")
				.append("jndiName=").append(jndiName)
				.append("]").toString();
	}
}
