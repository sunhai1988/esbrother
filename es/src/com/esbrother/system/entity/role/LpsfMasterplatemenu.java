package com.esbrother.system.entity.role;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LpsfMasterplatemenu implements Serializable {

    /** identifier field */
    private String id;

    /** nullable persistent field */
    private String masterplateName;

    /** nullable persistent field */
    private String pageurl;

    /** nullable persistent field */
    private String issystemmaterplate;

    /** nullable persistent field */
    private String limitdeclare;

    /** nullable persistent field */
    private String firstmasterplate;

    /** nullable persistent field */
    private int sort;

    /** nullable persistent field */
    private String fathermasterplatecode;

    /** nullable persistent field */
    private String islimitmasterplate;

    private int rootId;
    
    private String icon;
    private String introduction;
    /** full constructor */
    public LpsfMasterplatemenu(String masterplateName, String pageurl, String issystemmaterplate, String limitdeclare, String firstmasterplate, int sort, String fathermasterplatecode, String islimitmasterplate,String introduction,String icon) {
        this.masterplateName = masterplateName;
        this.pageurl = pageurl;
        this.issystemmaterplate = issystemmaterplate;
        this.limitdeclare = limitdeclare;
        this.firstmasterplate = firstmasterplate;
        this.sort = sort;
        this.fathermasterplatecode = fathermasterplatecode;
        this.islimitmasterplate = islimitmasterplate;
        this.icon = icon;
        this.introduction = introduction;
    }

    /** default constructor */
    public LpsfMasterplatemenu() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMasterplateName() {
        return this.masterplateName;
    }

    public void setMasterplateName(String masterplateName) {
        this.masterplateName = masterplateName;
    }

    public String getPageurl() {
        return this.pageurl;
    }

    public void setPageurl(String pageurl) {
        this.pageurl = pageurl;
    }

    public String getIssystemmaterplate() {
        return this.issystemmaterplate;
    }

    public void setIssystemmaterplate(String issystemmaterplate) {
        this.issystemmaterplate = issystemmaterplate;
    }

    public String getLimitdeclare() {
        return this.limitdeclare;
    }

    public void setLimitdeclare(String limitdeclare) {
        this.limitdeclare = limitdeclare;
    }

    public String getFirstmasterplate() {
        return this.firstmasterplate;
    }

    public void setFirstmasterplate(String firstmasterplate) {
        this.firstmasterplate = firstmasterplate;
    }

    public int getSort() {
        return this.sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getFathermasterplatecode() {
        return this.fathermasterplatecode;
    }

    public void setFathermasterplatecode(String fathermasterplatecode) {
        this.fathermasterplatecode = fathermasterplatecode;
    }

    public String getIslimitmasterplate() {
        return this.islimitmasterplate;
    }

    public void setIslimitmasterplate(String islimitmasterplate) {
        this.islimitmasterplate = islimitmasterplate;
    }

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getRootId() {
		return rootId;
	}

	public void setRootId(int rootId) {
		this.rootId = rootId;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LpsfMasterplatemenu) ) return false;
        LpsfMasterplatemenu castOther = (LpsfMasterplatemenu) other;
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
