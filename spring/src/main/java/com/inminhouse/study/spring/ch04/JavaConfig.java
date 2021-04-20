package com.inminhouse.study.spring.ch04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
// PropertySource 애너테이션은 Repeatable 애너테이션을 적용하고 있으므로 여러 개 사용 가능
@PropertySource("classpath:/ch04/db.properties")
public class JavaConfig {
	
	@Autowired
	private Environment env;

	@Bean(initMethod = "init")
	public ConnectionProviderImpl connectionProviderImpl() {
		return new ConnectionProviderImpl();
	}
	
	@Bean(initMethod = "init")
	public ConnectionProvider connectionProvider() {
		ConnectionProvider provider = new ConnectionProvider();
		provider.setDirver(env.getProperty("db.driver"));
		provider.setUser(env.getProperty("db.user"));
		provider.setPassword(env.getProperty("db.password"));
		provider.setUrl(env.getProperty("db.url"));
		return provider;
	}
	
}
