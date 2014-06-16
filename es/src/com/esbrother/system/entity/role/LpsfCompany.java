package com.esbrother.system.entity.role;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LpsfCompany implements Serializable {

    /** identifier field */
    private String id;

    /** nullable persistent field */
    private String companyName;

    /** nullable persistent field */
    private String chargeer;

    /** nullable persistent field */
    private String companyAddress;

    /** nullable persistent field */
    private String commAddress;

    /** nullable persistent field */
    private String zip;
    private String type;
    /** nullable persistent field */
    private String phone;

    /** nullable persistent field */
    private String remarks;

    /** full constructor */
    public LpsfCompany(String companyName, String chargeer, String companyAddress, String commAddress, String zip,String type, String phone, String remarks) {
        this.companyName = companyName;
        this.chargeer = chargeer;
        this.companyAddress = companyAddress;
        this.commAddress = commAddress;
        this.zip = zip;
        this.type=type;
        this.phone = phone;
        this.remarks = remarks;
    }

    /** default constructor */
    public LpsfCompany() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getChargeer() {
        return this.chargeer;
    }

    public void setChargeer(String chargeer) {
        this.chargeer = chargeer;
    }

    public String getCompanyAddress() {
        return this.companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCommAddress() {
        return this.commAddress;
    }

    public void setCommAddress(String commAddress) {
        this.commAddress = commAddress;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LpsfCompany) ) return false;
        LpsfCompany castOther = (LpsfCompany) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

}
