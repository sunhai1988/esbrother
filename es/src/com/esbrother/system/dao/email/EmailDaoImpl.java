package com.esbrother.system.dao.email;

import java.util.List;

import com.esbrother.system.form.EmailForm;
import com.esbrother.system.spring.BaseBO;


public class EmailDaoImpl extends BaseBO implements EmailDao {
	@Override
	public List queryEmail(String roder, String rp, EmailForm from) {

		StringBuffer hql = new StringBuffer();
		hql.append("Select to_name,to_email from send_email where 1=1 ");
		List list = commonDAO.queryForList(hql.toString(), new Object[] {
				roder, rp }, from);
		return list;
	}

	 
}
