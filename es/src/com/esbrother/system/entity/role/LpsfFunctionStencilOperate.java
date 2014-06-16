package com.esbrother.system.entity.role;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LpsfFunctionStencilOperate implements Serializable {

    /** identifier field */
    private String id;

    /** nullable persistent field */
    private String operateId;

    /** nullable persistent field */
    private String stencilId;

    /** full constructor */
    public LpsfFunctionStencilOperate(String operateId, String stencilId) {
        this.operateId = operateId;
        this.stencilId = stencilId;
    }

    /** default constructor */
    public LpsfFunctionStencilOperate() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperateId() {
        return this.operateId;
    }

    public void setOperateId(String operateId) {
        this.operateId = operateId;
    }

    public String getStencilId() {
        return this.stencilId;
    }

    public void setStencilId(String stencilId) {
        this.stencilId = stencilId;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LpsfFunctionStencilOperate) ) return false;
        LpsfFunctionStencilOperate castOther = (LpsfFunctionStencilOperate) other;
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
