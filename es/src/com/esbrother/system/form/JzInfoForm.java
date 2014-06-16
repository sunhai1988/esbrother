package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class JzInfoForm extends BaseForm {

	private String companyname;
	private String type;
	private String phone;
	private String chargeer;

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getChargeer() {
		return chargeer;
	}

	public void setChargeer(String chargeer) {
		this.chargeer = chargeer;
	}

}
