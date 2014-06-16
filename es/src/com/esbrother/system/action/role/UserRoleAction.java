package com.esbrother.system.action.role;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.esbrother.system.dao.role.UserRoleDao;
import com.esbrother.system.entity.role.LpsfUserRole;
import com.esbrother.system.form.UserRoleForm;
import com.esbrother.system.util.HtmlToJson;
import com.esbrother.system.util.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserRoleAction extends ActionSupport implements ModelDriven {
	private String order;
	private String sort;
	private UserRoleDao lpsfUserRoleDao;
	private LpsfUserRole ur;
	private UserRoleForm form = new UserRoleForm();
	private String id;
	private String strRole;

	public String queryUserRole() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = lpsfUserRoleDao.queryUserRole(order, sort, form);
			output = JsonSerializer.serialize1(result);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String savaOrUpdateUserRole() {
		try {
			lpsfUserRoleDao.addGroupToRole(strRole, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}

	public String queryByIdUserRoleAction() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		String result = null;
		try {
			LpsfUserRole result1 = lpsfUserRoleDao.queryById(id);
			output = HtmlToJson.toHtmlObjectone(result1);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String queryRole() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			output = lpsfUserRoleDao.queryByGroupRole(id);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String queryUsers() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = lpsfUserRoleDao.queryUsers();
			output = "[" + JsonSerializer.serializetoList(result) + "]";
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

	public UserRoleDao getLpsfUserRoleDao() {
		return lpsfUserRoleDao;
	}

	public void setLpsfUserRoleDao(UserRoleDao lpsfUserRoleDao) {
		this.lpsfUserRoleDao = lpsfUserRoleDao;
	}

	public LpsfUserRole getUr() {
		return ur;
	}

	public void setUr(LpsfUserRole ur) {
		this.ur = ur;
	}

	public String getStrRole() {
		return strRole;
	}

	public void setStrRole(String strRole) {
		this.strRole = strRole;
	}

}
