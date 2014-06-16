package com.esbrother.system.form;

import com.esbrother.system.hibernate.BaseForm;

public class EmailForm extends BaseForm {

	private String to_name;
	private String to_email;
	private String to_email_sp;
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
	public String getEmail_type() {
		return email_type;
	}
	public void setEmail_type(String email_type) {
		this.email_type = email_type;
	}
    

}
