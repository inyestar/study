package com.inminhouse.study.spring.ch11.template;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class GuestMessageDao {
	
	/*
	 * 커넥션을 구하거나 try-catch-fianlly로 하는 자원 관리 등
	 * SQL을 실행할 때 마다 입력해야하는 중복 코드를 제거할 수 있도록 도와주는 클래스
	 */
	private JdbcTemplate jdbcTemplate;
	
	public GuestMessageDao(DataSource datsSource) {
		jdbcTemplate = new JdbcTemplate(datsSource);
	}
}
