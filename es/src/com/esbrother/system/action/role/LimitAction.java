package com.esbrother.system.action.role;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.esbrother.system.dao.role.LpsfLimitDao;
import com.esbrother.system.entity.role.LpsfLimit;
import com.esbrother.system.form.QueryLimitForm;
import com.esbrother.system.util.HtmlToJson;
import com.esbrother.system.util.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LimitAction extends ActionSupport implements ModelDriven {
	private String order;
	private String sort;
	private LpsfLimitDao lpsfLimitDao;
	private LpsfLimit lo;
	private QueryLimitForm form = new QueryLimitForm();
	private String id;
	private String strString;
	private String text;

	public String queryLimit() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = lpsfLimitDao.queryRole(order, sort, form);
			output = JsonSerializer.serialize1(result);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String addLimit() {
		lpsfLimitDao.addLimit(lo);
		return NONE;
	}

	public String queryByIdLimit() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		String result = null;
		try {
			LpsfLimit result1 = lpsfLimitDao.queryById(id);
			output = HtmlToJson.toHtmlObjectone(result1);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String LimitAddMenu() {
		try {
			lpsfLimitDao.limitAddAction(id, text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}

	public String LimitqueryMenu() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		String result = null;
		try {
			result = lpsfLimitDao.LimitqueryMenu(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.write(result);
		out.close();
		return Action.NONE;
	}

	public String deleteLimit() {

		String[] args = id.split(":");
		lpsfLimitDao.deleteLimit(args);
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

	public LpsfLimitDao getLpsfLimitDao() {
		return lpsfLimitDao;
	}

	public void setLpsfLimitDao(LpsfLimitDao lpsfLimitDao) {
		this.lpsfLimitDao = lpsfLimitDao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LpsfLimit getLo() {
		return lo;
	}

	public void setLo(LpsfLimit lo) {
		this.lo = lo;
	}

	public String getStrString() {
		return strString;
	}

	public void setStrString(String strString) {
		this.strString = strString;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
