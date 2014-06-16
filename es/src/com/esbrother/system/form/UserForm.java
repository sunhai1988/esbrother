package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class UserForm extends BaseForm {
	private String dept_name;
	private String position_name;
	private String user_name;
	private String user_sex;
	private String prohibition;
	private String stime;
	private String etime;

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public String getProhibition() {
		return prohibition;
	}

	public void setProhibition(String prohibition) {
		this.prohibition = prohibition;
	}

}
