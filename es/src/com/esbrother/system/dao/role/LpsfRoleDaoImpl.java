package com.esbrother.system.dao.role;

import java.util.List;
import java.util.Map;
import com.esbrother.system.entity.role.LpsfRole;
import com.esbrother.system.entity.role.LpsfRoleLimit;
import com.esbrother.system.form.RoleForm;
import com.esbrother.system.spring.BaseBO;
import com.esbrother.system.util.StringUtil;

public class LpsfRoleDaoImpl extends BaseBO implements LpsfRoleDao {

	public List queryRole(String order, String rp, RoleForm form) {
		StringBuffer hql = new StringBuffer();
		hql.append("Select * from lpsf_role where 1=1 ");
		if (form.getName() != null) {
			hql.append("and name like '%" + form.getName() + "%'");
		}
		if (form.getRoleDeclare() != null) {
			hql.append("and role_declare like '%" + form.getRoleDeclare()
					+ "%'");
		}
		if (form.getRoleIsforbitten() != null) {
			hql.append("and role_isForbitten like '%"
					+ form.getRoleIsforbitten() + "%'");
		}
		if (form.getRemark() != null) {
			hql.append("and remark like '%" + form.getRemark() + "%'");
		}
		hql.append(" ORDER BY ? ?");
		List list = commonDAO.queryForList(hql.toString(), new Object[] {
				order, rp }, form);
		return list;
	}

	public List RolequeryLimit() {
		List list = commonDAO.queryForList("Select * from lpsf_limit ");
		return list;
	}

	public void addRole(LpsfRole lr) {
		commonDAO.saveOrUpdate(lr);
	}

	public LpsfRole queryById(String id) {
		LpsfRole of = (LpsfRole) ((List) commonDAO
				.query(" from LpsfRole as o where o.id='" + id + "'")).get(0);
		return of;
	}

	public void deleteRole(String[] ids) {
		if (ids.length == 1) {
			commonDAO.delete("from LpsfRole as role where role.id = ?", ids);
		} else {
			StringBuffer hql = new StringBuffer(256);
			hql.append("from LpsfRole as role where role.id in ");
			hql.append(StringUtil.getInExpFromArray(ids));
			commonDAO.delete(hql.toString());
		}
	}

	public List queryByIdLimit(String id) {
		List list = commonDAO
				.queryForList("select l.limitWay,l.limitDeclare,l.limitRemark "
						+ "from lpsf_role_limit p inner join lpsf_limit l on l.id=p.limit_id and p.role_id='"
						+ id + "'");
		return list;
	}

	public void RoleAddLimit(LpsfRoleLimit rl) {
		commonDAO.saveOrUpdate(rl);
	}

	public String queryByRoleId(String id) {
		List list = commonDAO
				.queryForList("select l.limitWay,l.id,p.limit_id from lpsf_limit l left join lpsf_role_limit p on l.id=p.limit_id and p.role_id='"
						+ id + "'");
		StringBuffer str = new StringBuffer();
		if (list != null) {
			str.append("[");
			for (int i = 0; i < list.size(); i++) {
				Map map = (Map) list.get(i);
				str.append("{").append("\"id\":")
						.append("\"" + map.get("id") + "\",")
						.append("\"limitWay\":")
						.append("\"" + map.get("limitWay") + "\"");
				if (map.get("limit_id") != null) {
					str.append(",\"limit_id\":").append(
							"\"" + map.get("limit_id") + "\"");
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

	public void addLimitToGroup(String str, String id) {
		String[] strId = str.split(",");
		commonDAO.delete("from LpsfRoleLimit as us where us.roleId = ?", id);
		for (int i = 0; i < strId.length; i++) {
			LpsfRoleLimit luu2 = new LpsfRoleLimit();
			luu2.setRoleId(id);
			luu2.setLimitId(strId[i]);
			commonDAO.saveOrUpdate(luu2);
		}
	}

}
