package com.esbrother.system.action.role;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.esbrother.system.dao.user.UserDao;
import com.esbrother.system.entity.user.LpsfUser;
import com.opensymphony.xwork2.ActionSupport;

public class FillterAction extends ActionSupport {
	private UserDao userDao;
	private String url;

	public String queryFilterAction() throws Exception {
		String json;
		String[] str = url.split("/");
		LpsfUser user = (LpsfUser) ServletActionContext.getRequest()
				.getSession().getAttribute("user");
		List<String> list = userDao.getUserAction(user.getId());
		if (list.contains(str[str.length - 1])) {
			json = "{\"result\":\"1\", \"msg\":\"有权限\"}";
		} else {
			json = "{\"result\":\"2\", \"msg\":\"没有权限\"}";
		}
		sendMsg(json);
		return NONE;
	}

	public void sendMsg(String content) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().write(content);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
