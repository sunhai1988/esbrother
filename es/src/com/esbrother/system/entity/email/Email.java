package com.esbrother.system.entity.email;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

 
public class Email implements Serializable {
	private static final long serialVersionUID = -2955530839779883680L;

	private String id;
    //省份
    private String to_name;
    private String to_email;
    private String to_email_sp;
    private int flag;
    private Date createtime;
    private String email_type;
    

    
     


	public String getTo_name() {
		return to_name;
	}


	public void setTo_name(String to_name) {
		this.to_name = to_name;
	}


	public String getTo_email() {
		return to_email;
	}


	public void setTo_email(String to_email) {
		this.to_email = to_email;
	}


	public String getTo_email_sp() {
		return to_email_sp;
	}


	public void setTo_email_sp(String to_email_sp) {
		this.to_email_sp = to_email_sp;
	}


	public int getFlag() {
		return flag;
	}


	public void setFlag(int flag) {
		this.flag = flag;
	}


	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getEmail_type() {
		return email_type;
	}


	public void setEmail_type(String email_type) {
		this.email_type = email_type;
	}


	public Email(String to_name,String to_email,String to_email_sp,int flag, Date createtime,String email_type) {
    	   this.to_name=to_name;
    	   this.to_email=to_email;
    	   this.to_email_sp=to_email_sp;
    	   this.flag=flag;
    	   this.createtime=createtime;
    	   this.email_type=email_type;
    }

   
    public Email() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
 
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof Email) ) return false;
        Email castOther = (Email) other;
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
