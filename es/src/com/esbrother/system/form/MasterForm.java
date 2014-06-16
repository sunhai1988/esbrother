package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class MasterForm extends BaseForm {
	private String masterName;
	private String masterCode;

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getMasterCode() {
		return masterCode;
	}

	public void setMasterCode(String masterCode) {
		this.masterCode = masterCode;
	}

}
