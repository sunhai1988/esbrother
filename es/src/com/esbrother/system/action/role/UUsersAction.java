package com.esbrother.system.action.role;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.esbrother.system.dao.role.UUsersDao;
import com.esbrother.system.entity.role.LpsfUserUsers;
import com.esbrother.system.form.UUsersForm;
import com.esbrother.system.util.HtmlToJson;
import com.esbrother.system.util.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UUsersAction extends ActionSupport implements ModelDriven {
	private String order;
	private String sort;
	private UUsersDao uusersDao;
	private LpsfUserUsers luu;
	private UUsersForm form = new UUsersForm();
	private String id;
	private String strString;

	public String queryUUsers() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = uusersDao.queryUUsers(order, sort, form);
			output = JsonSerializer.serialize1(result);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String savaOrUpdateUUsers() {
		try {
			uusersDao.addUserToGroup(strString, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}

	public String queryByIdUUsersAction() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		String result = null;
		try {
			LpsfUserUsers result1 = uusersDao.queryById(id);
			output = HtmlToJson.toHtmlObjectone(result1);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String queryUser1() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = uusersDao.queryUser1();
			output = "[" + JsonSerializer.serializetoList(result) + "]";
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String queryUsers1() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			output = uusersDao.queryByUserGroup(id);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}
	
	public String queryCompanyByRadio() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			output = uusersDao.queryCompanyByRadio();
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public Object getModel() {
		return form;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UUsersDao getUusersDao() {
		return uusersDao;
	}

	public void setUusersDao(UUsersDao uusersDao) {
		this.uusersDao = uusersDao;
	}

	public LpsfUserUsers getLuu() {
		return luu;
	}

	public void setLuu(LpsfUserUsers luu) {
		this.luu = luu;
	}

	public String getStrString() {
		return strString;
	}

	public void setStrString(String strString) {
		this.strString = strString;
	}

}
