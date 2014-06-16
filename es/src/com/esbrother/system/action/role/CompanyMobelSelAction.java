package com.esbrother.system.action.role;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.esbrother.system.dao.role.LpsfCompanyDao;
import com.esbrother.system.entity.role.LpsfCompanyMenu;
import com.esbrother.system.form.CompanyMobleSelForm;
import com.esbrother.system.util.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class CompanyMobelSelAction implements ModelDriven {
	private String order;
	private String sort;
	private LpsfCompanyDao companyDao;
	private CompanyMobleSelForm formComSM = new CompanyMobleSelForm();
	private String id;
	private String text;
	private String type;
	private String url;
	private String companyselid;
	private String companymobelselid;
	private String templateid;

	/*** 新增企业选择的模块的查询的语句 ***/
	public String companyQuerySelmobel() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = companyDao.companyQuerySelMobel(order, sort, formComSM);
			output = JsonSerializer.serialize1(result);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	/** 保存企业选择模板 **/
	public String companyMobelSave() throws Exception {
		String[] args = id.split(":");
		LpsfCompanyMenu co = new LpsfCompanyMenu();
		co.setCompanyId(companyselid);
		co.setId(companymobelselid);
		co.setIndustryHomeId(id);
		co.setTemplateId(templateid);
		co.setUrl(url);
		companyDao.resetCompanyMob(co);
		return Action.NONE;
	}

	public Object getModel() {
		return formComSM;
	}

	public String getCompanyselid() {
		return companyselid;
	}

	public void setCompanyselid(String companyselid) {
		this.companyselid = companyselid;
	}

	public String getCompanymobelselid() {
		return companymobelselid;
	}

	public void setCompanymobelselid(String companymobelselid) {
		this.companymobelselid = companymobelselid;
	}

	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public CompanyMobleSelForm getFormComSM() {
		return formComSM;
	}

	public void setFormComSM(CompanyMobleSelForm formComSM) {
		this.formComSM = formComSM;
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
}
