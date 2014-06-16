package com.esbrother.system.entity.user;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LpsfUser implements Serializable {

	private String id;
	private String department_id;
	private String position_id;
	private String user_name;
	private String ming;
	private String user_pass;
	private String user_sex;
	private String remark;
	private String prohibition;
	private String companyId;
	private String type;

	public LpsfUser(String department_id, String position_id, String user_name,
			String user_pass, String user_sex, String remark, String prohibition) {

		this.department_id = department_id;
		this.position_id = position_id;
		this.user_name = user_name;

		this.user_pass = user_pass;
		this.user_sex = user_sex;
		this.remark = remark;
		this.prohibition = prohibition;

	}

	/** default constructor */
	public LpsfUser() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	public String getPosition_id() {
		return position_id;
	}

	public void setPosition_id(String position_id) {
		this.position_id = position_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMing() {
		return ming;
	}

	public void setMing(String ming) {
		this.ming = ming;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getProhibition() {
		return prohibition;
	}

	public void setProhibition(String prohibition) {
		this.prohibition = prohibition;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public boolean equals(Object other) {
		if (!(other instanceof LpsfUser))
			return false;
		LpsfUser castOther = (LpsfUser) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId())
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

}
