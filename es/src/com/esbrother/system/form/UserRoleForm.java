package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class UserRoleForm extends BaseForm {
	private String users_name;
	private String name;

	public String getUsers_name() {
		return users_name;
	}

	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
