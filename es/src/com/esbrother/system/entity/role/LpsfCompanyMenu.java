package com.esbrother.system.entity.role;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LpsfCompanyMenu implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** identifier field */
    private String id;

    /** nullable persistent field */
    private String companyId;

    /** nullable persistent field */
    private String templateId;

    /** nullable persistent field */
    private String url;

    /** nullable persistent field */
    private String industryHomeId;

    /** full constructor */
    public LpsfCompanyMenu(String companyId, String templateId, String url, String industryHomeId) {
        this.companyId = companyId;
        this.templateId = templateId;
        this.url = url;
        this.industryHomeId = industryHomeId;
    }

    /** default constructor */
    public LpsfCompanyMenu() {
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

    public String getTemplateId() {
        return this.templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIndustryHomeId() {
        return this.industryHomeId;
    }

    public void setIndustryHomeId(String industryHomeId) {
        this.industryHomeId = industryHomeId;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LpsfCompanyMenu) ) return false;
        LpsfCompanyMenu castOther = (LpsfCompanyMenu) other;
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
