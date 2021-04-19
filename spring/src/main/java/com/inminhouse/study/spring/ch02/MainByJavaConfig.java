package com.inminhouse.study.spring.ch02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJavaConfig {

	public static void main(String[] args) {
		
		/*
		 * 생성자 파라미터로 여러 개의 클래스 타입이나 패키지 경로를 전달할 수 있다.
		 */
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
		MainByXml.runAuthAndCatchEx(authSvc, "bkchoi", "1111");
		MainByXml.runAuthAndCatchEx(authSvc, "bkchoi", "11111");
		MainByXml.runAuthAndCatchEx(authSvc, "bkchoi", "111111");
		MainByXml.runAuthAndCatchEx(authSvc, "bkchoi", "1111111");
		MainByXml.runAuthAndCatchEx(authSvc, "bkchoi", "11111111");
		MainByXml.runAuthAndCatchEx(authSvc, "bkchoi", "111111111");
		MainByXml.runAuthAndCatchEx(authSvc, "bkchoi2", "1111");
		MainByXml.runAuthAndCatchEx(authSvc, "bkchoi", "1234");
		
		PasswordChangeService pwChgSvc = ctx.getBean("pwChangeSvc", PasswordChangeService.class);
		MainByXml.runAuthAndCatchEx(pwChgSvc, "bkchoi2", "1234", "5678");
		MainByXml.runAuthAndCatchEx(pwChgSvc, "bkchoi", "1234", "5678");
		MainByXml.runAuthAndCatchEx(authSvc, "bkchoi", "1234");
		MainByXml.runAuthAndCatchEx(authSvc, "bkchoi", "5678");
		
		/*
		 * factory 방식 빈 설정
		 */
		ClientFactoryBean factory = ctx.getBean("clientFactoryBean", ClientFactoryBean.class);
		ctx.close();
	}
	
}

