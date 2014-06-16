package com.esbrother.system.dao.info;

import java.util.List;

import com.esbrother.system.entity.role.JzInfo;
import com.esbrother.system.entity.role.LpsfCompany;
import com.esbrother.system.form.JzInfoForm;

public interface JzInfoDao {
	 
	public List queryJzInfo(String roder, String rp, JzInfoForm form);
	public void saveOrUpdateJzInfo(JzInfo lc);

	public LpsfCompany findJzinfById(String id);

	public void deleteJzinf(String[] ids);

	public String companyQueryMenu(String id, String type);

	public void addCompanyMenu(String id, String ids);

	public String companyQueryMenuOfTrade(String id);

}
