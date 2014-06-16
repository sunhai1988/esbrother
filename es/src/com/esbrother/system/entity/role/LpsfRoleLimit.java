package com.esbrother.system.entity.role;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LpsfRoleLimit implements Serializable {

    /** identifier field */
    private String id;

    /** nullable persistent field */
    private String roleId;

    /** nullable persistent field */
    private String limitId;

    /** full constructor */
    public LpsfRoleLimit(String roleId, String limitId) {
        this.roleId = roleId;
        this.limitId = limitId;
    }

    /** default constructor */
    public LpsfRoleLimit() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getLimitId() {
        return this.limitId;
    }

    public void setLimitId(String limitId) {
        this.limitId = limitId;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LpsfRoleLimit) ) return false;
        LpsfRoleLimit castOther = (LpsfRoleLimit) other;
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
