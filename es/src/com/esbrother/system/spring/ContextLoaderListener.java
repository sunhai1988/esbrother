package com.esbrother.system.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.WebUtils;

public class ContextLoaderListener extends
		org.springframework.web.context.ContextLoaderListener {
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);

		ServletContext sc = event.getServletContext();
		WebUtils.setWebAppRootSystemProperty(sc);

		ApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(sc);

		BeanFactory.initAppCtx(ac);
	}

	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}
}