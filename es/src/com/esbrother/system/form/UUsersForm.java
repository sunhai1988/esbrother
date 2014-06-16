package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class UUsersForm extends BaseForm {
	private String user_name;
	private String users_name;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUsers_name() {
		return users_name;
	}

	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}

}
