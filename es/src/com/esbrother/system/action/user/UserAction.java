package com.esbrother.system.action.user;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.esbrother.system.dao.user.UserDao;
import com.esbrother.system.entity.user.LpsfUser;
import com.esbrother.system.form.UserForm;
import com.esbrother.system.util.HtmlToJson;
import com.esbrother.system.util.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven {
	private InputStream pdfStream;
	private String order;
	private String sort;
	private String id;
	private UserDao userDao;
	UserForm form = new UserForm();
	private LpsfUser of;
	private String type;
	private String pageName;

	public String queryUser() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = userDao.queryUser(sort, order, form);
			output = JsonSerializer.serialize1(result);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}
	
	public String addUser() throws Exception {
		try {
			userDao.addDesUser(of);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}

	public String addaUser() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		try {
			int flage = userDao.queryByName(of);
			if (flage == 0) {
				output = "{'suc':'0', 'msg':'用户名已存在'}";
			} else {
				output = "{'suc':'1', 'msg':'操作成功'}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return NONE;

	}

	public String deleteUser() throws Exception {
		try {
			String[] args = id.split(":");
			userDao.delUser(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}

	public String queryByIdAction() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		String result = null;
		try {
			LpsfUser result1 = userDao.queryById(id);
			output = HtmlToJson.toHtmlObjectone(result1);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String queryPosition() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = userDao.queryPosition();
			output = "[" + JsonSerializer.serializetoList(result) + "]";
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String queryDepartment() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = userDao.queryDepartment();
			output = "[" + JsonSerializer.serializetoList(result) + "]";
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String userIdqueryMenu() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String result = null;
		try {
			result = userDao.userIdqueryMenu(((LpsfUser) session
					.getAttribute("user")).getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.write(result);
		out.close();
		return Action.NONE;
	}

	// 按钮权限Action
	public String btUesrByUserIdPage() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		List result = null;
		String output;
		try {
			result = userDao
					.btUesrByUserIdPage(
							((LpsfUser) session.getAttribute("user")).getId(),
							pageName);
			output = "[" + JsonSerializer.serializetoList(result) + "]";
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String buqueryMenu() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String result = null;
		try {
			result = userDao.buqueryMenu(((LpsfUser) session
					.getAttribute("user")).getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.write(result);
		out.close();
		return Action.NONE;
	}

	public Object getModel() {
		return form;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public LpsfUser getOf() {
		return of;
	}

	public void setOf(LpsfUser of) {
		this.of = of;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public InputStream getPdfStream() {
		return pdfStream;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

}
