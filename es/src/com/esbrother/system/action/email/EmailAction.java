package com.esbrother.system.action.email;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.esbrother.system.dao.email.EmailDao;
import com.esbrother.system.dao.role.LpsfCompanyDao;
import com.esbrother.system.entity.role.LpsfCompany;
import com.esbrother.system.form.CompanyForm;
import com.esbrother.system.form.CompanyMobelForm;
import com.esbrother.system.form.CompanyMobleSelForm;
import com.esbrother.system.form.EmailForm;
import com.esbrother.system.util.HtmlToJson;
import com.esbrother.system.util.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmailAction extends ActionSupport implements ModelDriven {
	private String order;
	private String sort;
	private LpsfCompanyDao companyDao;
	private EmailDao emailDao;
	private LpsfCompany co;
	private EmailForm form = new EmailForm();
	private CompanyMobelForm formComM=new CompanyMobelForm();
	private CompanyMobleSelForm formComSM=new CompanyMobleSelForm();
	private String id;
	private String text;
	private String type;

	public String queryEmail() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = emailDao.queryEmail(order, sort, form);
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
		companyDao.saveOrUpdateCompany(co);
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
			LpsfCompany result1 = companyDao.findByIdCompany(id);
			output = HtmlToJson.toHtmlObjectone(result1);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String companyQueryMenu() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		String result = null;
		try {
			result = companyDao.companyQueryMenu(id, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.write(result);
		out.close();
		return Action.NONE;
	}
	
	public String companyQueryMenuOfTrade() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		String result = null;
		try {
			result = companyDao.companyQueryMenuOfTrade(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.write(result);
		out.close();
		return Action.NONE;
	}

	public String deleteCompany() throws Exception {
		String[] args = id.split(":");
		companyDao.deleteCompany(args);
		return Action.NONE;
	}
	
	public String addCompanyMenu() {
		try {
			companyDao.addCompanyMenu(id, text);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public LpsfCompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(LpsfCompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	public LpsfCompany getCo() {
		return co;
	}

	public void setCo(LpsfCompany co) {
		this.co = co;
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
	 

	public EmailDao getEmailDao() {
		return emailDao;
	}

	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

	public EmailForm getForm() {
		return form;
	}

	public void setForm(EmailForm form) {
		this.form = form;
	}

	public CompanyMobelForm getFormComM() {
		return formComM;
	}

	public CompanyMobleSelForm getFormComSM() {
		return formComSM;
	}

	public void setFormComSM(CompanyMobleSelForm formComSM) {
		this.formComSM = formComSM;
	}

	public void setFormComM(CompanyMobelForm formComM) {
		this.formComM = formComM;
	}

}
