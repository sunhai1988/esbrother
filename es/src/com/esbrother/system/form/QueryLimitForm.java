package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class QueryLimitForm extends BaseForm {
	private String limitWay;
	private String limitDeclare;
	private String limitRemark;

	public String getLimitWay() {
		return limitWay;
	}

	public void setLimitWay(String limitWay) {
		this.limitWay = limitWay;
	}

	public String getLimitDeclare() {
		return limitDeclare;
	}

	public void setLimitDeclare(String limitDeclare) {
		this.limitDeclare = limitDeclare;
	}

	public String getLimitRemark() {
		return limitRemark;
	}

	public void setLimitRemark(String limitRemark) {
		this.limitRemark = limitRemark;
	}

}
