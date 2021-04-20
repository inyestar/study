package com.inminhouse.study.spring.ch04.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DatasourceConfigDev {
	
	@Bean
	public JdbcConnectionProvider connProvider() {
		JdbcConnectionProvider conn = new JdbcConnectionProvider();
		conn.setDirver("mysql");
		conn.setPassword("1234");
		conn.setUser("madvirus");
		conn.setUrl("127.0.0.1");
		return conn;
	}

}
