package com.inminhouse.study.spring.ch06.annotation;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.inminhouse.study.spring.ch06.quickstart.Article;

@Aspect
public class ArticleCacheAspect {

	private Map<Integer, Article> cache = new HashMap<>();
	
	/*
	 * Around가 아닌 다른 Advice에서 JoinPoint를 사용할 경우 반드시 첫 번째 파라미터로 와야하며 아니면 익셉션 발생
	 */
	@Around("execution(public * *..ReadableArticleService.*(..))")
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
