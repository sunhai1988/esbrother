package com.esbrother.system.action.info;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.esbrother.system.dao.info.JzInfoDao;
import com.esbrother.system.dao.role.LpsfCompanyDao;
import com.esbrother.system.entity.role.JzInfo;
import com.esbrother.system.entity.role.LpsfCompany;
import com.esbrother.system.form.CompanyForm;
import com.esbrother.system.form.CompanyMobelForm;
import com.esbrother.system.form.CompanyMobleSelForm;
import com.esbrother.system.form.JzInfoForm;
import com.esbrother.system.util.HtmlToJson;
import com.esbrother.system.util.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class JzinfoAction extends ActionSupport implements ModelDriven {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String order;
	private String sort;
	private JzInfo co;
	private JzInfoForm form = new JzInfoForm();
	 
	private String id;
	private String text;
	private String type;
	private JzInfoDao jzInfoDao;

	public JzInfoDao getJzInfoDao() {
		return jzInfoDao;
	}

	public void setJzInfoDao(JzInfoDao jzInfoDao) {
		this.jzInfoDao = jzInfoDao;
	}

	public String queryJzinfo() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = jzInfoDao.queryJzInfo(sort, order, form);
			 
			output = JsonSerializer.serialize1(result);
		 
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String addCompany() {
		 
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

	 
 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public JzInfo getCo() {
		return co;
	}

	public void setCo(JzInfo co) {
		this.co = co;
	}

	public JzInfoForm getForm() {
		return form;
	}

	public void setForm(JzInfoForm form) {
		this.form = form;
	}
	 
	 

	 

	 
}
