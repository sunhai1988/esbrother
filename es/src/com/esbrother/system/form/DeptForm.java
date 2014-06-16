package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class DeptForm extends BaseForm {
	private String deptName;
	private String deptDes;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDes() {
		return deptDes;
	}

	public void setDeptDes(String deptDes) {
		this.deptDes = deptDes;
	}

}
