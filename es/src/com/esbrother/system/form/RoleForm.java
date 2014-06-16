package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class RoleForm extends BaseForm {
	private String name;
	private String roleDeclare;
	private String roleIsforbitten;
	private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleDeclare() {
		return roleDeclare;
	}

	public void setRoleDeclare(String roleDeclare) {
		this.roleDeclare = roleDeclare;
	}

	public String getRoleIsforbitten() {
		return roleIsforbitten;
	}

	public void setRoleIsforbitten(String roleIsforbitten) {
		this.roleIsforbitten = roleIsforbitten;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
