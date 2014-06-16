package com.esbrother.system.entity.role;

import java.io.Serializable;

/** @author Hibernate CodeGenerator */
public class LpsfLimitRole implements Serializable {
private String limitWay;
private String limitDeclare;
private String limitRemark;
private String name;
private String roleDeclare;
private String roleIsforbitten;
private String remark;

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
public String getLimitWay() {
	return limitWay;
}

}
