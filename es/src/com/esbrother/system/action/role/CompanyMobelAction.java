package com.esbrother.system.action.role;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.esbrother.system.dao.role.LpsfCompanyDao;
import com.esbrother.system.entity.role.LpsfCompany;
import com.esbrother.system.form.CompanyMobelForm;
import com.esbrother.system.util.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class CompanyMobelAction implements ModelDriven {
	private String order;
	private String sort;
	private LpsfCompanyDao companyDao;
	private LpsfCompany co;
	private CompanyMobelForm formComM = new CompanyMobelForm();
	private String id;
	private String text;

	private String type;

	/*** 新增企业选择的模块的查询的语句 ***/
	public String companyQuerymobel() throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = companyDao.companyQueryMobel(order, sort, formComM);
			output = JsonSerializer.serialize1(result);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
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

	public CompanyMobelForm getFormComM() {
		return formComM;
	}

	public void setFormComM(CompanyMobelForm formComM) {
		this.formComM = formComM;
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

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return formComM;
	}

}
