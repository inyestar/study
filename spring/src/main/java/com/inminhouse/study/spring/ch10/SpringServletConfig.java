package com.inminhouse.study.spring.ch10;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// 서블릿3부터 web.xml에서 설정하던 서블릿과 필터에 대한 설정을 자바 코드로도 구현 가능하게 변경되었다.
public class SpringServletConfig implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("읽히니?");
		XmlWebApplicationContext ctx = new XmlWebApplicationContext();
		ctx.setConfigLocation("/WEB-INF/conf/ch-09.xml");
		
		DispatcherServlet dispatcher = new DispatcherServlet(ctx);
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcher);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}

}
