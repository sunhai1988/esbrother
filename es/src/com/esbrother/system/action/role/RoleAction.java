package com.esbrother.system.action.role;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.esbrother.system.dao.role.LpsfRoleDao;
import com.esbrother.system.entity.role.LpsfRole;
import com.esbrother.system.entity.role.LpsfRoleLimit;
import com.esbrother.system.form.RoleForm;
import com.esbrother.system.util.HtmlToJson;
import com.esbrother.system.util.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RoleAction extends ActionSupport implements ModelDriven {
	private String order;
	private String sort;
	private LpsfRoleDao lpsfRoleDao;
	private LpsfRoleLimit roleLimit;
	private LpsfRole lo;
	private RoleForm form = new RoleForm();
	private String id;
	private String strString;

	public String queryRole() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = lpsfRoleDao.queryRole(order, sort, form);
			output = JsonSerializer.serialize1(result);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String RolequeryLimit() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = lpsfRoleDao.RolequeryLimit();
			output = "[" + JsonSerializer.serializetoList(result) + "]";
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String addRole() {
		lpsfRoleDao.addRole(lo);
		return NONE;
	}

	public String RoleAddLimit() {
		lpsfRoleDao.addLimitToGroup(strString, id);
		return NONE;
	}

	public String RolequeryByIdLimit() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String result = null;
		try {
			result = lpsfRoleDao.queryByRoleId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.write(result);
		out.close();
		return Action.NONE;
	}

	public String queryLimitByRoleId() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = lpsfRoleDao.queryByIdLimit(id);
			output = "[" + JsonSerializer.serializetoList(result) + "]";
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String queryByIdRole() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		String result = null;
		try {
			LpsfRole result1 = lpsfRoleDao.queryById(id);
			output = HtmlToJson.toHtmlObjectone(result1);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String queryByRoleIdLimit() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = lpsfRoleDao.queryByIdLimit(id);
			output = "[" + JsonSerializer.serializetoList(result) + "]";
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String deleteRole() {
		String[] args = id.split(":");
		lpsfRoleDao.deleteRole(args);
		return NONE;
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

	public LpsfRoleDao getLpsfRoleDao() {
		return lpsfRoleDao;
	}

	public void setLpsfRoleDao(LpsfRoleDao lpsfRoleDao) {
		this.lpsfRoleDao = lpsfRoleDao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LpsfRole getLo() {
		return lo;
	}

	public void setLo(LpsfRole lo) {
		this.lo = lo;
	}

	public LpsfRoleLimit getRoleLimit() {
		return roleLimit;
	}

	public void setRoleLimit(LpsfRoleLimit roleLimit) {
		this.roleLimit = roleLimit;
	}

	public String getStrString() {
		return strString;
	}

	public void setStrString(String strString) {
		this.strString = strString;
	}

}
