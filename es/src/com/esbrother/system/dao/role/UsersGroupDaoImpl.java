package com.esbrother.system.dao.role;

import java.util.List;

import com.esbrother.system.entity.role.LpsfUsers;

import com.esbrother.system.form.UsersGroupForm;
import com.esbrother.system.spring.BaseBO;
import com.esbrother.system.util.StringUtil;

public class UsersGroupDaoImpl extends BaseBO implements UsersGroupDao {

	public List queryUsersGroup(String order, String rp, UsersGroupForm form) {
		StringBuffer hql = new StringBuffer();
		hql.append(" Select * from lpsf_users where 1=1 ");
		if (form.getUsers_name() != null) {
			hql.append("and users_name like '%" + form.getUsers_name() + "%'");
		}
		hql.append("ORDER BY ? ?");
		List list = commonDAO.queryForList(hql.toString(), new Object[] {
				order, rp }, form);
		return list;
	}

	public LpsfUsers queryById(String id) {
		LpsfUsers of = (LpsfUsers) ((List) commonDAO
				.query(" from LpsfUsers as lu where lu.id='" + id + "'"))
				.get(0);
		return of;
	}

	public void delUsersGroup(String[] ids) throws Exception {
		if (ids.length == 1) {
			commonDAO.delete("from LpsfUsers as lu where lu.id = ?", ids);
		} else {
			StringBuffer hql = new StringBuffer(256);
			hql.append("from LpsfUsers as lu where lu.id in ");
			hql.append(StringUtil.getInExpFromArray(ids));
			commonDAO.delete(hql.toString());
		}
	}

	public void addDesUsersGroup(LpsfUsers lu) throws Exception {
		commonDAO.saveOrUpdate(lu);
	}

	public List queryRole1() {
		List list = commonDAO.queryForList("select id,name from lpsf_role");
		return list;
	}

}
