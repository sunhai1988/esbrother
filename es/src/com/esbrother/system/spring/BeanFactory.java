package com.esbrother.system.spring;

import org.springframework.context.ApplicationContext;

public class BeanFactory {
	static ApplicationContext ctx = null;

	public static void initAppCtx(ApplicationContext context) {
		ctx = context;
	}

	public static Object getBean(String id) throws Exception {
		if (ctx == null) {
			throw new Exception("Spring context has not been initialized!");
		}
		return ctx.getBean(id);
	}
}
