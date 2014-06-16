package com.esbrother.system.filter;



import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RightFilter implements Filter {
	Log log = LogFactory.getLog(getClass());

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		String currentURL = request.getRequestURI(); // 取得根目录所对应的绝对路径:
		String targetURL = "";
		if (!currentURL.equals("/")) {
			// 截取到当前文件名用于比较
			targetURL = currentURL.substring(currentURL.indexOf("/", 1),
					currentURL.length());// 本地
			// targetURL = currentURL.substring(currentURL.indexOf("/",
			// 0),currentURL.length());//服务器
		}
		if (session.getAttribute("user") == null) {
			if (!targetURL.equals("/login.html")
					&& !targetURL.equals("/internet_note.html")) {
				response.sendRedirect(request.getContextPath() + "/login.html");
				return;
			}
			chain.doFilter(request, response);
			return;
		} else {
			chain.doFilter(request, response);
			return;
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}
}
