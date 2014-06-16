package com.esbrother.system.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.WebUtils;

public class ContextLoaderServlet extends
		org.springframework.web.context.ContextLoaderServlet {
	private static final long serialVersionUID = -4605051400412396685L;
	static Log logger = LogFactory.getLog(ContextLoaderServlet.class);

	public void init() throws ServletException {
		super.init();

		ServletContext sc = getServletContext();

		WebUtils.setWebAppRootSystemProperty(sc);

		ApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(sc);

		BeanFactory.initAppCtx(ac);
	}
}
