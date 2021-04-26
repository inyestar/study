package com.inminhouse.study.spring.ch06.pojo;

import com.inminhouse.study.spring.ch06.quickstart.Article;
import com.inminhouse.study.spring.ch06.quickstart.ArticleDao;

public class ReadableArticleServiceImpl implements ReadableArticleService {

	private ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public Article read(Integer id) {
		System.out.printf("ReadArticleServiceImpl.read(%d) 호출\n", id);
		return articleDao.selectById(id);
	}

}
