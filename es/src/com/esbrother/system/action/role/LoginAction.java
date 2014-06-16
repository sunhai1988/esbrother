package com.esbrother.system.action.role;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.MDC;
import org.apache.struts2.ServletActionContext;
import com.esbrother.system.dao.user.UserDao;
import com.esbrother.system.entity.user.LpsfUser;
import com.esbrother.system.form.UserForm;
import com.esbrother.system.util.DesUtils;
import com.esbrother.system.util.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven {
	Log log = LogFactory.getLog(getClass());
	private String json;
	private UserForm from = new UserForm();
	private UserDao userDao;
	private LpsfUser of;
	private String getType;
	private String companyid;
	private String template_name;
	DesUtils des = new DesUtils();

	public void changePass() throws Exception {
		try {
			String[] str = json.split(",");
			String oldpass = str[0];
			String newpass = str[1];
			int result = 0;
			LpsfUser user = (LpsfUser) ServletActionContext.getRequest()
					.getSession().getAttribute("user");
			if (!oldpass.equals(user.getUser_pass())) {
				json = "{\"suc\":\"0\", \"msg\":\"旧密码输入错误!\"}";
			} else {
				try {
					result = userDao.changePass(newpass, user);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (result == 1) {
					json = "{\"suc\":\"1\", \"msg\":\"密码修改成功,请重新登录!\"}";
				} else {
					json = "{\"suc\":\"2\", \"msg\":\"密码修改失败!\"}";
				}
			}
			sendMsg(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login() throws Exception {
		String[] str = json.split(",");
		String loginName = str[0];
		String password = str[1];
		List list = null;
		list = userDao.validator(loginName, password);
		if (list.size() != 0) {
			LpsfUser of = (LpsfUser) list.get(0);
			if (of.getProhibition().equals("1")) {
				json = "{\"suc\":\"2\", \"msg\":\"该号码已经禁用,请联系管理员!\"}";
			} else {
				ServletActionContext.getRequest().getSession()
						.setAttribute("user", of);
				MDC.put("userName", of.getUser_name());
				String warn = "用户:" + of.getUser_name() + "登陆        IP:"
						+ ServletActionContext.getRequest().getRemoteAddr();
				log.warn(warn);
				json = "{\"suc\":\"1\", \"msg\":\"登录成功!\"}";

			}
		} else {
			json = "{\"suc\":\"0\", \"msg\":\"用户或者密码错误!\"}";
		}
		sendMsg(json);
	}

	public void logout() throws Exception {
		ServletActionContext.getRequest().getSession().invalidate();
		json = "{\"suc\":\"1\", \"msg\":\"退出成功!\"}";
		sendMsg(json);
	}

	public void denglu() throws Exception {
		LpsfUser user = (LpsfUser) (ServletActionContext.getRequest()
				.getSession().getAttribute("user"));
		json = "{\"suc\":\"1\", \"msg\":\"" + user.getMing() + "\"}";
		sendMsg(json);
	}

	public void getReportHomePage() throws Exception {
		String output = "";
		try {
			LpsfUser user = (LpsfUser) (ServletActionContext.getRequest()
					.getSession().getAttribute("user"));
			String type = userDao.getReportHomePage(user);
//			output = UploadConfigurationRead.getInstance().getConfigItem(type)
//					.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		json = "{\"suc\":\"1\", \"msg\":\"" + output + "\"}";
		sendMsg(json);
	}

	public void getHomePageImage() throws Exception {
		String output = "";
		try {
			output = userDao.getHomePageImage(des.decrypt(companyid),
					des.decrypt(template_name));
		} catch (Exception e) {
			e.printStackTrace();
		}
		json = "{\"suc\":\"1\", \"msg\":\"" + output + "\"}";
		sendMsg(json);
	}

	public void getdluserUsername() throws Exception {
		LpsfUser user = (LpsfUser) (ServletActionContext.getRequest()
				.getSession().getAttribute("user"));
		String name = user.getUser_name();
		json = "{\"suc\":\"1\", \"msg\":\"" + name + "\"}";
		sendMsg(json);
	}

	public void queryUserLog() {
		String output;
		List result = null;
		try {
			result = userDao.queryLog(from);
			output = JsonSerializer.serialize1(result);
			sendMsg(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendMsg(String content) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(content);
	}

	public String GetPageDelayTime() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output = userDao.GetPageDelayTime();
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public Object getModel() {
		return from;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public String getTemplate_name() {
		return template_name;
	}

	public void setTemplate_name(String templateName) {
		template_name = templateName;
	}
}
