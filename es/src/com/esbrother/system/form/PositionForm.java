package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class PositionForm extends BaseForm {
	private String company_name;
	private String position_name;

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

}
