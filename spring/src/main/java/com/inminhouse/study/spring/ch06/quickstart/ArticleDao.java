package com.inminhouse.study.spring.ch06.quickstart;

public interface ArticleDao {

	void insert(Article article);

	Article selectById(Integer id);
}
