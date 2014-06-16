package com.esbrother.system.dao.email;

import java.util.List;

import com.esbrother.system.form.EmailForm;

public interface EmailDao {
	 
	public List queryEmail(String roder, String rp, EmailForm form);
	 

}
