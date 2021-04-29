package com.inminhouse.study.spring.ch08;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.tomcat.util.scan.StandardJarScanner;
import org.eclipse.jetty.apache.jsp.JettyJasperInitializer;
import org.eclipse.jetty.jsp.JettyJspServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {

	public static void main(String[] args) {
		JettyServer server = new JettyServer();
		server.start();
	}
	
	private void start() {
		Server server = new Server(8080);
		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/");
		webapp.setCompactPath(true);
//		webapp.setDescriptor("src/main/webapp/WEB-INFs/web.xml");
		webapp.setResourceBase("src/main/webapp");
		webapp.setParentLoaderPriority(true);
		
		try {
			enableJspSupport(webapp);
			server.setHandler(webapp);
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * jsp support 설정
	 * ref: https://github.com/jetty-project/embedded-jetty-jsp/blob/master/src/main/java/org/eclipse/jetty/demo/Main.java
	 * @param handler
	 * @throws IOException 
	 */
	private void enableJspSupport(ServletContextHandler handler) throws IOException {
		
		// make scratch directory to write temporary files in temp diretory.
		File tempDir = new File(System.getProperty("java.io.tmpdir"));
		File scratchDir = new File(tempDir.toString(), "embedded-jetty-jsp");
		if (!scratchDir.exists() && !scratchDir.mkdirs()) {
			throw new IOException("Unable to create scratch directory: " + scratchDir);
		}
		
		handler.setAttribute("javax.servlet.context.tempdir", scratchDir);

		ClassLoader jspClassLoader = new URLClassLoader(new URL[0], handler.getClass().getClassLoader());
		handler.setClassLoader(jspClassLoader);
		handler.addBean(new JspStarter(handler));
		
		ServletHolder holderJsp = new ServletHolder("jsp", JettyJspServlet.class);
		holderJsp.setInitOrder(0);
		holderJsp.setInitParameter("logVerbosityLevel", "DEBUG");
		holderJsp.setInitParameter("fork", "false");
		holderJsp.setInitParameter("xpoweredBy", "false");
		holderJsp.setInitParameter("compilerTargetVM", "1.8");
		holderJsp.setInitParameter("compilerSourceVM", "1.8");
		holderJsp.setInitParameter("keepgenerated", "true");
		handler.addServlet(holderJsp, "*.jsp");
		
	}
	
	public static class JspStarter extends AbstractLifeCycle implements ServletContextHandler.ServletContainerInitializerCaller
	{
		JettyJasperInitializer sci;
		ServletContextHandler context;
		
		public JspStarter (ServletContextHandler context)
		{
			this.sci = new JettyJasperInitializer();
			this.context = context;
			this.context.setAttribute("org.apache.tomcat.JarScanner", new StandardJarScanner());
		}

		@Override
		protected void doStart() throws Exception
		{
			ClassLoader old = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(context.getClassLoader());
			try
			{
				sci.onStartup(null, context.getServletContext());   
				super.doStart();
			}
			finally
			{
				Thread.currentThread().setContextClassLoader(old);
			}
		}
	}
}
