package com.inminhouse.study.spring.ch06.pojo;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

import com.inminhouse.study.spring.ch06.quickstart.Article;

public class ArticleCacheAdvice {

	private Map<Integer, Article> cache = new HashMap<>();
	
	/*
	 * around advice를 사용할 경우 ProceedingJoinPoint 메소드를 첫 번째 파라미터로 사용하지 않으면 익셉션 발생
	 */
	public Article cache(ProceedingJoinPoint joinPoint) throws Throwable {
		Integer id = (Integer) joinPoint.getArgs()[0];
		Article article = cache.get(id);
		if(article != null) {
			System.out.println("[ACA] 캐시에서 article[" + id + "] 획득");
			return article;
		}
		
		Article result = (Article) joinPoint.proceed(); // 대상 객체의 실제 메소드 호출
		if(result != null) {
			cache.put(id, result);
			System.out.println("[ACA] 캐시에 article[" + id + "] 추가");
		}
		return result;
	}
}
