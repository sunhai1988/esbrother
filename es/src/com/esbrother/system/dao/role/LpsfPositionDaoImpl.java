package com.esbrother.system.dao.role;

import java.util.List;
import java.util.Map;

import com.esbrother.system.entity.role.LpsfPosition;
import com.esbrother.system.entity.user.LpsfUser;
import com.esbrother.system.form.PositionForm;
import com.esbrother.system.spring.BaseBO;
import com.esbrother.system.util.StringUtil;

public class LpsfPositionDaoImpl extends BaseBO implements LpsfPositionDao {

	public List queryPosition1(String order, String rp, PositionForm form) {
		StringBuffer hql = new StringBuffer();
		hql.append("Select l.id,lc.company_name,l.position_name,l.position_des from lpsf_position as l left outer  join lpsf_company as lc on l.company_id=lc.id where 1=1 ");
		if (form.getCompany_name() != null) {
			hql.append("and lc.company_name like '%" + form.getCompany_name()
					+ "%'");
		}
		if (form.getPosition_name() != null) {
			hql.append("and l.position_name like '%" + form.getPosition_name()
					+ "%'");
		}
		hql.append("ORDER BY ? ?");
		List list = commonDAO.queryForList(hql.toString(), new Object[] {
				order, rp }, form);
		return list;
	}

	public void saveOrUpdatePosition(LpsfPosition lp) {
		commonDAO.saveOrUpdate(lp);
	}

	public LpsfPosition findByIdPosition(String id) {
		LpsfPosition of = (LpsfPosition) ((List) commonDAO
				.query(" from LpsfPosition as l where l.id='" + id + "'"))
				.get(0);
		return of;
	}

	public LpsfPosition findByPosition(String id) {
		LpsfUser of = (LpsfUser) ((List) commonDAO
				.query(" from LpsfUser as lu where lu.id='" + id + "'")).get(0);
		LpsfPosition lp = (LpsfPosition) ((List) commonDAO
				.query(" from LpsfPosition as l where l.id='"
						+ of.getPosition_id() + "'")).get(0);
		return lp;
	}

	public List queryCompany1() {
		List list = commonDAO
				.queryForList("select id,company_name from lpsf_company");
		return list;
	}

	public void deletePosition(String[] ids) {
		if (ids.length == 1) {
			commonDAO.delete("from LpsfPosition as o where o.id = ?", ids);
		} else {
			StringBuffer hql = new StringBuffer(256);
			hql.append("from LpsfPosition as o where o.id in ");
			hql.append(StringUtil.getInExpFromArray(ids));
			commonDAO.delete(hql.toString());
		}
	}

	public String queryEquipCompany(String id) throws Exception {
		String sql = "select company_name from lpsf_company where id=(select company_id from equipment where id='"
				+ id + "')";
		List list = commonDAO.queryForList(sql);
		if (!list.isEmpty()) {
			Map map = (Map) list.get(0);
			return map.get("company_name").toString();
		}
		return "";
	}
}
