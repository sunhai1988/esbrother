package com.esbrother.system.entity.role;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LpsfUsers implements Serializable {

    /** identifier field */
    private String id;

    /** nullable persistent field */
    private String usersName;

    /** nullable persistent field */
    private String usersInstr;

    /** full constructor */
    public LpsfUsers(String usersName, String usersInstr) {
        this.usersName = usersName;
        this.usersInstr = usersInstr;
    }

    /** default constructor */
    public LpsfUsers() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsersName() {
        return this.usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getUsersInstr() {
        return this.usersInstr;
    }

    public void setUsersInstr(String usersInstr) {
        this.usersInstr = usersInstr;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LpsfUsers) ) return false;
        LpsfUsers castOther = (LpsfUsers) other;
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
