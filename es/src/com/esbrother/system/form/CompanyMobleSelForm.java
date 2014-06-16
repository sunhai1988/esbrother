package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class CompanyMobleSelForm extends BaseForm {
	private String industry_name;
	private String industry_system;
	private String industry_id;
	private String companysel_id;
	private String companymobelsel_id;
	private String template_id;

	public String getIndustry_name() {
		return industry_name;
	}

	public void setIndustry_name(String industryName) {
		industry_name = industryName;
	}

	public String getIndustry_system() {
		return industry_system;
	}

	public String getIndustry_id() {
		return industry_id;
	}

	public void setIndustry_id(String industryId) {
		industry_id = industryId;
	}

	public void setIndustry_system(String industrySystem) {
		industry_system = industrySystem;
	}

	public String getCompanysel_id() {
		return companysel_id;
	}

	public void setCompanysel_id(String companyselId) {
		companysel_id = companyselId;
	}

	public String getCompanymobelsel_id() {
		return companymobelsel_id;
	}

	public void setCompanymobelsel_id(String companymobelselId) {
		companymobelsel_id = companymobelselId;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String templateId) {
		template_id = templateId;
	}

}
