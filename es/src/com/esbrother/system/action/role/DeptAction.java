package com.esbrother.system.action.role;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.esbrother.system.dao.role.LpsfDeptDao;
import com.esbrother.system.entity.role.LpsfDepartment;
import com.esbrother.system.form.DeptForm;
import com.esbrother.system.util.HtmlToJson;
import com.esbrother.system.util.JsonSerializer;
import com.esbrother.system.util.MessageUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeptAction extends ActionSupport implements ModelDriven {
	private String order;
	private String sort;
	private LpsfDeptDao lpsfDeptDao;
	private LpsfDepartment dp;
	private DeptForm form = new DeptForm();
	private String id;

	public String queryDept() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = lpsfDeptDao.queryDept(order, sort, form);
			output = JsonSerializer.serialize1(result);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String savaOrUpdateDept() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		lpsfDeptDao.addDept(dp);
		String json = MessageUtil.message(MessageUtil.MESSAGE_OK);
		out.write(json);
		out.close();
		return NONE;
	}

	public String queryByIdDeptAction() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		String result = null;
		try {
			LpsfDepartment result1 = lpsfDeptDao.queryById(id);
			output = HtmlToJson.toHtmlObjectone(result1);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String queryComp() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = lpsfDeptDao.queryComp();
			output = "[" + JsonSerializer.serializetoList(result) + "]";
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String deleteDept() throws Exception {
		String[] args = id.split(":");
		lpsfDeptDao.deleteDept(args);
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

	public LpsfDeptDao getLpsfDeptDao() {
		return lpsfDeptDao;
	}

	public void setLpsfDeptDao(LpsfDeptDao lpsfDeptDao) {
		this.lpsfDeptDao = lpsfDeptDao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LpsfDepartment getDp() {
		return dp;
	}

	public void setDp(LpsfDepartment dp) {
		this.dp = dp;
	}

}
