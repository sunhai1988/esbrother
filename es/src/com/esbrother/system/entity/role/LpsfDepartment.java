package com.esbrother.system.entity.role;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LpsfDepartment implements Serializable {

    /** identifier field */
    private String id;

    /** nullable persistent field */
    private String companyId;

    /** nullable persistent field */
    private String deptName;

    /** nullable persistent field */
    private String deptDes;

    /** nullable persistent field */
    private String remarks;

    /** full constructor */
    public LpsfDepartment(String companyId, String deptName, String deptDes, String remarks) {
        this.companyId = companyId;
        this.deptName = deptName;
        this.deptDes = deptDes;
        this.remarks = remarks;
    }

    /** default constructor */
    public LpsfDepartment() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDes() {
        return this.deptDes;
    }

    public void setDeptDes(String deptDes) {
        this.deptDes = deptDes;
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
        if ( !(other instanceof LpsfDepartment) ) return false;
        LpsfDepartment castOther = (LpsfDepartment) other;
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
