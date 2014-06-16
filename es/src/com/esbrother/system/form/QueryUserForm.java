package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class QueryUserForm extends BaseForm {

	String usrid;
	String name;

	public String getUsrid() {
		return usrid;
	}

	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
