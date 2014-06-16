package com.esbrother.system.entity.role;

import java.io.Serializable;

/** @author Hibernate CodeGenerator */
public class LpsfLimit implements Serializable {
	private String id;
	private String limitWay;
	private String limitDeclare;
	private String limitRemark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
