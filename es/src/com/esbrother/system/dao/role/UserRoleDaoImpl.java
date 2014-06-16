package com.esbrother.system.dao.role;

import java.util.List;
import java.util.Map;
import com.esbrother.system.entity.role.LpsfUserRole;
import com.esbrother.system.form.UserRoleForm;
import com.esbrother.system.spring.BaseBO;

public class UserRoleDaoImpl extends BaseBO implements UserRoleDao {

	public List queryUserRole(String order, String rp, UserRoleForm form) {

		StringBuffer hql = new StringBuffer();
		hql.append("Select ur.id,u.users_name,r.name from lpsf_user_role as ur left outer join lpsf_users as u on ur.user_group_id=u.id left outer join lpsf_role as r on ur.role_id=r.id where 1=1 ");
		if (form.getUsers_name() != null) {
			hql.append("and u.users_name like '%" + form.getUsers_name() + "%'");
		}
		if (form.getName() != null) {
			hql.append("and r.name like '%" + form.getName() + "%'");
		}
		List list = commonDAO.queryForList(hql.toString(), form);
		return list;
	}

	public void addUserRole(LpsfUserRole ur) {
		commonDAO.saveOrUpdate(ur);
	}

	public LpsfUserRole queryById(String id) {
		LpsfUserRole of = (LpsfUserRole) ((List) commonDAO
				.query(" from LpsfUserRole as ur where ur.id='" + id + "'"))
				.get(0);
		return of;
	}

	public List queryRole() {
		List list = commonDAO.queryForList("select id,name from lpsf_role");
		return list;
	}

	public List queryUsers() {
		List list = commonDAO
				.queryForList("select id,users_name from lpsf_users");
		return list;
	}

	public String queryByGroupRole(String id) {
		List list = commonDAO
				.queryForList("select r.name,lu.user_group_id ,r.id from lpsf_role as r left join lpsf_user_role as lu on r.id=lu.role_id and lu.user_group_id='"
						+ id + "'");
		StringBuffer str = new StringBuffer();
		if (list != null) {
			str.append("[");
			for (int i = 0; i < list.size(); i++) {
				Map map = (Map) list.get(i);
				str.append("{").append("\"id\":")
						.append("\"" + map.get("id") + "\",")
						.append("\"name\":")
						.append("\"" + map.get("name") + "\"");
				if (map.get("user_group_id") != null) {
					str.append(",\"user_group_id\":").append(
							"\"" + map.get("user_group_id") + "\"");
				}
				str.append("}");
				if (i < list.size() - 1) {
					str.append(",");
				}
			}
			str.append("]");
		}
		return str.toString();
	}

	public void addGroupToRole(String str, String id) {
		String[] strId = str.split(",");
		commonDAO
				.delete("from LpsfUserRole as ur where ur.userGroupId = ?", id);
		for (int i = 0; i < strId.length; i++) {
			LpsfUserRole luu2 = new LpsfUserRole();
			luu2.setUserGroupId(id);
			luu2.setRoleId(strId[i]);
			commonDAO.saveOrUpdate(luu2);
		}
	}
}
