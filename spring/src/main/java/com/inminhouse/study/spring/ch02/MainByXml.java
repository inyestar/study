package com.inminhouse.study.spring.ch02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		/*
		 * GenericXmlapplicationContext 생성자의 파라미터로
		 * 여러 개의 파일 명, 패키지 명, asterisk(*) 사용 가능
		 */
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/ch02/application-context.xml");
		AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
		runAuthAndCatchEx(authSvc, "bkchoi", "1111");
		runAuthAndCatchEx(authSvc, "bkchoi", "11111");
		runAuthAndCatchEx(authSvc, "bkchoi", "111111");
		runAuthAndCatchEx(authSvc, "bkchoi", "1111111");
		runAuthAndCatchEx(authSvc, "bkchoi", "11111111");
		runAuthAndCatchEx(authSvc, "bkchoi", "111111111");
		runAuthAndCatchEx(authSvc, "bkchoi2", "1111");
		runAuthAndCatchEx(authSvc, "bkchoi", "1234");
		
		PasswordChangeService pwChgSvc = ctx.getBean("pwChangeSvc", PasswordChangeService.class);
		runAuthAndCatchEx(pwChgSvc, "bkchoi2", "1234", "5678");
		runAuthAndCatchEx(pwChgSvc, "bkchoi", "1234", "5678");
		runAuthAndCatchEx(authSvc, "bkchoi", "1234");
		runAuthAndCatchEx(authSvc, "bkchoi", "5678");
		ctx.close();
	}

	public static void runAuthAndCatchEx(AuthenticationService authSvc, String inputId, String inputPw) {
		try {
			authSvc.authenticate(inputId, inputPw);
		} catch (UserNotFoundException | AuthException e) {
			e.printStackTrace();
		} 
	}
	
	public static void runAuthAndCatchEx(PasswordChangeService pwChgSvc, String inputId, String oldPw, String newPw) {
		try {
			pwChgSvc.changePassword(inputId, oldPw, newPw);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
