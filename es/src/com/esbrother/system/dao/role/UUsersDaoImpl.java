package com.esbrother.system.dao.role;

import java.util.List;
import java.util.Map;
import com.esbrother.system.entity.role.LpsfUserUsers;
import com.esbrother.system.form.UUsersForm;
import com.esbrother.system.spring.BaseBO;

public class UUsersDaoImpl extends BaseBO implements UUsersDao {

	public List queryUUsers(String order, String rp, UUsersForm form) {

		StringBuffer hql = new StringBuffer();
		hql.append("Select a.id,b.user_name,c.users_name from lpsf_user_users as a left outer join lpsf_user as b on a.user_id=b.id left outer join lpsf_users as c on a.users_id=c.id where 1=1 ");

		if (form.getUser_name() != null) {
			hql.append("and b.user_name like '%" + form.getUser_name() + "%'");
		}
		if (form.getUsers_name() != null) {
			hql.append("and c.users_name like '%" + form.getUsers_name() + "%'");
		}
		List list = commonDAO.queryForList(hql.toString(), form);
		return list;
	}

	public void addUUsers(LpsfUserUsers luu) {
		commonDAO.saveOrUpdate(luu);
	}

	public LpsfUserUsers queryById(String id) {
		LpsfUserUsers of = (LpsfUserUsers) ((List) commonDAO
				.query(" from LpsfUserUsers as a where a.id='" + id + "'"))
				.get(0);
		return of;
	}

	public List queryUser1() {
		List list = commonDAO
				.queryForList("select id,user_name from lpsf_user");
		return list;
	}

	public List queryUsers1() {
		List list = commonDAO
				.queryForList("select id,users_name from lpsf_users");
		return list;
	}

	public String queryByUserGroup(String id) {
		List list = commonDAO
				.queryForList("select r.users_name,lu.user_id ,r.id from lpsf_users as r left join lpsf_user_users as lu on r.id=lu.users_id and user_id='"
						+ id + "'");
		StringBuffer str = new StringBuffer();
		if (list != null) {
			str.append("[");
			for (int i = 0; i < list.size(); i++) {
				Map map = (Map) list.get(i);
				str.append("{").append("\"id\":")
						.append("\"" + map.get("id") + "\",")
						.append("\"users_name\":")
						.append("\"" + map.get("users_name") + "\"");
				if (map.get("user_id") != null) {
					str.append(",\"user_id\":").append(
							"\"" + map.get("user_id") + "\"");
					str.append(",\"checkbox\":").append("\"true\"");
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

	public String queryCompanyByRadio() {
		String hql = "select company_name from lpsf_company";
		List list = commonDAO.queryForList(hql);
		StringBuffer str = new StringBuffer();
		if (list != null) {
			str.append("[");
			for (int i = 0; i < list.size(); i++) {
				Map map = (Map) list.get(i);
				str.append("{").append("\"company_name\":")
						.append("\"" + map.get("company_name") + "\"");
				str.append("}");
				if (i < list.size() - 1) {
					str.append(",");
				}
			}
			str.append("]");
		}
		return str.toString();
	}

	public void addUserToGroup(String str, String id) {
		String[] strId = str.split(",");
		commonDAO.delete("from LpsfUserUsers as us where us.userId = ?", id);
		for (int i = 0; i < strId.length; i++) {
			LpsfUserUsers luu2 = new LpsfUserUsers();
			luu2.setUserId(id);
			luu2.setUsersId(strId[i]);
			commonDAO.saveOrUpdate(luu2);
		}
	}
}
