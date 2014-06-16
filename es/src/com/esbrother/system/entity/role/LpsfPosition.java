package com.esbrother.system.entity.role;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LpsfPosition implements Serializable {

    /** identifier field */
    private String id;

    /** nullable persistent field */
    private String companyId;

    /** nullable persistent field */
    private String positionName;

    /** nullable persistent field */
    private String positionDes;

    /** full constructor */
    public LpsfPosition(String companyId, String positionName, String positionDes) {
        this.companyId = companyId;
        this.positionName = positionName;
        this.positionDes = positionDes;
    }

    /** default constructor */
    public LpsfPosition() {
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

    public String getPositionName() {
        return this.positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionDes() {
        return this.positionDes;
    }

    public void setPositionDes(String positionDes) {
        this.positionDes = positionDes;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LpsfPosition) ) return false;
        LpsfPosition castOther = (LpsfPosition) other;
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
