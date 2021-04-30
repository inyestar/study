package com.inminhouse.study.spring.ch10;

import javax.servlet.Filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

// 미리 여러가지 설정을 구현해놓은 추상 클래스
// disaptcher servlet을 직접 생성할 필요가 없음
// xml 설정을 사용할 경우
public class SpringServletConfigXml extends AbstractDispatcherServletInitializer{

	@Override
	protected WebApplicationContext createServletApplicationContext() {
		XmlWebApplicationContext ctx = new XmlWebApplicationContext();
		ctx.setConfigLocation("/WEB-INF/conf/ch-09.xml");
		return ctx;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected String getServletName() {
		return "dispatcher3";
	}

	@Override
	protected WebApplicationContext createRootApplicationContext() {
//		XmlWebApplicationContext ctx = new XmlWebApplicationContext();
//		ctx.setConfigLocation("/WEB-INF/conf/root.xml");
//		return ctx;
		// root 컨텍스트가 없다면 null 리턴
		return null;
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("utf-8");
		return new Filter[] {encodingFilter};
	}


}
