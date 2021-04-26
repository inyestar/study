package com.inminhouse.study.spring.ch06.quickstart;

import java.util.HashMap;
import java.util.Map;

public class MemoryArticleDao implements ArticleDao {
	
	private int no = 0;
	private Map<Integer, Article> store = new HashMap<>();

	@Override
	public void insert(Article article) {
		System.out.println("MemoryArticleDao.insert() 호출");
		no++;
		article.setId(no);
		store.put(no, article);
	}
	
	@Override
	public Article selectById(Integer id) {
		return store.get(id);
	}

}
