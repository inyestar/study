package com.inminhouse.study.spring.ch06.quickstart;

public class WritableArticleServiceImpl implements WritableArticleService{
	
	private ArticleDao articleDao;

	public WritableArticleServiceImpl(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public void write(NewArticleRequest request) {
		System.out.println("WritableArticleServiceImpl.wirte() 호출");
		Article article = new Article(request.getWriterName(), request.getTitle(), request.getContent());
		articleDao.insert(article);
	}

}
