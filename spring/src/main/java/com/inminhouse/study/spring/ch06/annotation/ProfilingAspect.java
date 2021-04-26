package com.inminhouse.study.spring.ch06.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProfilingAspect {

	/*
	 * pointcut 적용된 메서드는 리턴타입이 void 이어야 한다.
	 * 포인트컷 메소드의 접근제어자는 그대로 반영되므로 외부에서 사용할 경우 private이면 익셉션 발생
	 */
	@Pointcut("execution(public * com.inminhouse.study.spring.ch06.quickstart..*(..))")
	private void profileTarget() {
		
	}

	/*
	 * 참조하는 포인트컷 메소드의 이름은 범위에 따라 사용 방식이 달라진다.
	 * 같은 클래스일 경우 메소드명만
	 * 같은 패키지 다른 클래스일 경우 단순한클래스이름.메서드명
	 * 다른 패키지일 경우 완전한클래스이름.메서드명
	 */
	@Around("profileTarget()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + " 시작");
		long start = System.currentTimeMillis();
		try {
			return joinPoint.proceed();
		} finally {
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행 시간 : " + (finish - start) + "ms");
		}
	}
}
