package com.inminhouse.study.spring.ch04.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class DatasourceConfigProd {
	
	@Bean
	public JndiConnectionProvider connProvider() {
		JndiConnectionProvider conn = new JndiConnectionProvider();
		conn.setJndiName("java:/comp/env/jdbc/db");
		return conn;
	}

}
