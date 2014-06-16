package com.esbrother.system.entity.role;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LpsfRole implements Serializable {

    /** identifier field */
    private String id;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String roleDeclare;

    /** nullable persistent field */
    private String roleIsforbitten;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public LpsfRole(String name, String roleDeclare, String roleIsforbitten, String remark) {
        this.name = name;
        this.roleDeclare = roleDeclare;
        this.roleIsforbitten = roleIsforbitten;
        this.remark = remark;
    }

    /** default constructor */
    public LpsfRole() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleDeclare() {
        return this.roleDeclare;
    }

    public void setRoleDeclare(String roleDeclare) {
        this.roleDeclare = roleDeclare;
    }

    public String getRoleIsforbitten() {
        return this.roleIsforbitten;
    }

    public void setRoleIsforbitten(String roleIsforbitten) {
        this.roleIsforbitten = roleIsforbitten;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LpsfRole) ) return false;
        LpsfRole castOther = (LpsfRole) other;
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
