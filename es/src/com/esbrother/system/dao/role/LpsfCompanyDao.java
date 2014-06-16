package com.esbrother.system.dao.role;

import java.util.List;
import com.esbrother.system.entity.role.LpsfCompany;
import com.esbrother.system.entity.role.LpsfCompanyMenu;
import com.esbrother.system.form.CompanyForm;
import com.esbrother.system.form.CompanyMobelForm;
import com.esbrother.system.form.CompanyMobleSelForm;

public interface LpsfCompanyDao {
	public List queryCompany(String roder, String rp, CompanyForm from);

	public void saveOrUpdateCompany(LpsfCompany lc);

	public LpsfCompany findByIdCompany(String id);

	public void deleteCompany(String[] ids);

	public String companyQueryMenu(String id, String type);

	public void addCompanyMenu(String id, String ids);

	public String companyQueryMenuOfTrade(String id);

	/** 企业已选择模板的查询语句 **/
	public List companyQueryMobel(String roder, String rp, CompanyMobelForm from);

	/** 企业所有模板列表的查询语句 **/
	public List companyQuerySelMobel(String roder, String rp,
			CompanyMobleSelForm from);

	/** 从新设置企业所选的模板 **/
	public void resetCompanyMob(LpsfCompanyMenu co);
}
