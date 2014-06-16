package com.esbrother.system.dao.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.esbrother.system.entity.role.JzInfo;
import com.esbrother.system.entity.role.LpsfCompany;
import com.esbrother.system.entity.role.LpsfCompanyMenu;
import com.esbrother.system.form.CompanyForm;
import com.esbrother.system.form.CompanyMobelForm;
import com.esbrother.system.form.CompanyMobleSelForm;
import com.esbrother.system.form.JzInfoForm;
import com.esbrother.system.spring.BaseBO;
import com.esbrother.system.util.Node;
import com.esbrother.system.util.Recursion;


public class JzInfoDaoImpl extends BaseBO implements JzInfoDao {

	public List queryCompany(String roder, String rp, CompanyForm from) {

		StringBuffer hql = new StringBuffer();
		hql.append("Select * from lpsf_company where 1=1 ");

		if (from.getCompanyname() != null && !"".equals(from.getCompanyname())) {
			hql.append(" and company_name = '" + from.getCompanyname() + "'");
		}
		if (from.getPhone() != null && !"".equals(from.getPhone())) {
			hql.append(" and phone = '" + from.getPhone() + "'");
		}
		if (from.getChargeer() != null && !"".equals(from.getChargeer())) {
			hql.append(" and chargeer = '" + from.getChargeer() + "'");
		}
		if (from.getType() != null && !"".equals(from.getType())) {
			hql.append(" and type = '" + from.getType() + "'");
		}
		hql.append(" ORDER BY ? ?");
		List list = commonDAO.queryForList(hql.toString(), new Object[] {
				roder, rp }, from);
		return list;
	}

	public void saveOrUpdateCompany(LpsfCompany lc) {
		commonDAO.saveOrUpdate(lc);
	}

	public LpsfCompany findByIdCompany(String id) {
		LpsfCompany of = (LpsfCompany) ((List) commonDAO
				.query(" from LpsfCompany as o where o.id='" + id + "'"))
				.get(0);
		return of;
	}

	public void deleteCompany(String[] ids) {
		 
	}

	public String companyQueryMenu(String id, String type) {
		List<Node> listNode = new ArrayList<Node>();
		List list1 = commonDAO
				.queryForList("select ltt.fatherTemplateCode,ltt.root_id,ltt.id,ltt.template_name,lcm.company_id from lpsf_trade_template as ltt left join lpsf_company_menu lcm on ltt.id=lcm.template_id and lcm.company_id='"
						+ id + "'");
		for (int i = 0; i < list1.size(); i++) {
			Map map = (Map) list1.get(i);
			Node node = new Node();
			node.setParentId(Integer.valueOf((String) map
					.get("fatherTemplateCode")));
			node.setNodeId((Integer) map.get("root_id"));
			node.setMenuId((String) map.get("id"));
			node.setTextName((String) map.get("template_name"));
			node.setPdId((String) map.get("company_id"));
			listNode.add(node);
		}
		Recursion r = new Recursion();
		String str = r.recursionZTreeMenu(listNode, new Node(1, 0));
		String trstStr = r.modifyStrToZTreeMenu(str);
		return trstStr;
	}

	public String companyQueryMenuOfTrade(String id) {
		List<Node> listNode = new ArrayList<Node>();
		String sql = "select ltt.fatherTemplateCode,ltt.root_id,ltt.id,ltt.template_name,lcm.company_id from lpsf_trade_template as ltt left join lpsf_company_menu lcm on ltt.id=lcm.template_id and lcm.company_id=(select lc.id from lpsf_company as lc,lpsf_user as lu where lc.id = lu.company_id and lu.id='"
				+ id + "') where lcm.company_id <>'null'";
		List list1 = commonDAO.queryForList(sql);
		for (int i = 0; i < list1.size(); i++) {
			Map map = (Map) list1.get(i);
			Node node = new Node();
			node.setParentId(Integer.valueOf((String) map
					.get("fatherTemplateCode")));
			node.setNodeId((Integer) map.get("root_id"));
			node.setMenuId((String) map.get("id"));
			node.setTextName((String) map.get("template_name"));
			node.setPdId((String) map.get("company_id"));
			listNode.add(node);
		}
		Recursion r = new Recursion();
		String str = r.recursionZTreeMenu(listNode, new Node(1, 0));
		String trstStr = r.modifyStrToZTreeMenu(str);
		return trstStr;
	}

	public void addCompanyMenu(String id, String ids) {
		String[] strId = ids.split(",");
		commonDAO.delete("from LpsfCompanyMenu as lcm where lcm.companyId = ?",id);
		for (int i = 0; i < strId.length; i++) {
			LpsfCompanyMenu f = new LpsfCompanyMenu();
			f.setCompanyId(id);
			f.setTemplateId(strId[i]);
			String sql = "select pageUrl from lpsf_trade_template where id='"
					+ strId[i] + "'";
			List list = commonDAO.queryForList(sql);
			if (!list.isEmpty()) {
				Map map = (Map) list.get(0);
				f.setUrl((String) map.get("pageUrl"));
			}
			commonDAO.save(f);
		}
	}

	public List companyQueryMobel(String roder, String rp, CompanyMobelForm from) {
		StringBuffer hql = new StringBuffer();
		hql.append("select lcm.id,ltt.template_name,lcm.template_id,ltt.root_id,ltt.fatherTemplateCode,ltt.firstTemplate,lcm.url,lcm.company_id,lc.company_address,lc.chargeer,lc.company_name from lpsf_trade_template as ltt INNER join lpsf_company_menu lcm on ltt.id=lcm.template_id  inner join lpsf_company  as lc on lc.id=lcm.company_id and ltt.fatherTemplateCode>1");
		List list = null;
		if (from.getCompany_id() != null && !"".equals(from.getCompany_id())) {
			hql.append(" and lc.id = '" + from.getCompany_id() + "'");

		} else {
			hql.append(" and lc.id = '-1'");
		}
		if (from.getTemplate_name() != null
				&& !"".equals(from.getTemplate_name())) {
			hql.append(" and ltt.template_name like '"
					+ from.getTemplate_name() + "%'");
		}
		hql.append("and ltt.fatherTemplateCode in (select root_id from lpsf_trade_template where template_name='"
						+ from.getTypename() + "')" + " ORDER BY ? ?");
		list = commonDAO.queryForList(hql.toString(),
				new Object[] { roder, rp }, from);
		return list;
	}

	public List companyQuerySelMobel(String roder, String rp,
			CompanyMobleSelForm from) {
		StringBuffer hql = new StringBuffer();
		hql.append("select CASE when lcm.id  is null then '' else '已选择' END as flag,lih.* FROM lpsf_company_menu as lcm RIGHT join lpsf_industry_home as lih on lcm.industry_home_id =lih.id where 1=1");
		List list = null;
		if (from.getIndustry_system() != null&& !"".equals(from.getIndustry_system())) {
			hql.append(" and lih.industry_system like '"
					+ from.getIndustry_system() + "%'");
		} else {
			hql.append(" and lih.industry_system='0'");
		}
		if (from.getIndustry_name() != null
				&& !"".equals(from.getIndustry_name())) {
			hql.append(" and lih.industry_name like '"
					+ from.getIndustry_name() + "%'");
		}
		hql.append(" ORDER BY ? ?");
		list = commonDAO.queryForList(hql.toString(),
				new Object[] { roder, rp }, from);

		return list;
	}

	/** 重新设置企业的所选择的模板 **/
	public void resetCompanyMob(LpsfCompanyMenu co) {
		commonDAO.saveOrUpdate(co);
	}

	@Override
	public void deleteJzinf(String[] ids) {
		 
		
	}

	@Override
	public LpsfCompany findJzinfById(String id) {
		 
		return null;
	}

	@Override
	public List queryJzInfo(String ider, String rp, JzInfoForm from) {
		StringBuffer hql = new StringBuffer();
		hql.append("Select id,title,address,phone,qq from jz_info where 1=1 ");
		List list = commonDAO.queryForList(hql.toString(), from);
		return list; 
		 
	}

	@Override
	public void saveOrUpdateJzInfo(JzInfo lc) {
	 
	}

 

}
