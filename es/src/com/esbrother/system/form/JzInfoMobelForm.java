package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class JzInfoMobelForm extends BaseForm {
	private String template_name;
	private String company_id;
	private String typename;
	public String getTemplate_name() {
		return template_name;
	}
	public void setTemplate_name(String templateName) {
		template_name = templateName;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String companyId) {
		company_id = companyId;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}

}
