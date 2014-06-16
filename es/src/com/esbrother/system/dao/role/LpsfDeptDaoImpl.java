package com.esbrother.system.dao.role;

import java.util.List;
import com.esbrother.system.entity.role.LpsfDepartment;
import com.esbrother.system.form.DeptForm;
import com.esbrother.system.spring.BaseBO;
import com.esbrother.system.util.StringUtil;

public class LpsfDeptDaoImpl extends BaseBO implements LpsfDeptDao {

	public List queryDept(String order, String rp, DeptForm from) {
		StringBuffer hql = new StringBuffer();
		hql.append("select lc.company_name,ld.* from lpsf_company as lc,lpsf_department ld where lc.id = ld.company_id");
		if (from.getDeptName() != null) {
			hql.append(" and ld.dept_name like '%" + from.getDeptName() + "%'");
		}
		if (from.getDeptDes() != null) {
			hql.append(" and ld.dept_des like '%" + from.getDeptDes() + "%'");
		}
		List list = commonDAO.queryForList(hql.toString(), from);
		return list;
	}

	public void addDept(LpsfDepartment dp) {
		commonDAO.saveOrUpdate(dp);
	}

	public LpsfDepartment queryById(String id) {
		LpsfDepartment ld = (LpsfDepartment) ((List) commonDAO
				.query(" from LpsfDepartment as o where o.id='" + id + "'"))
				.get(0);
		return ld;
	}

	public List queryComp() {
		List list = commonDAO.queryForList("select * from lpsf_company");
		return list;
	}

	public void deleteDept(String[] ids) {
		if (ids.length == 1) {
			commonDAO.delete("from LpsfDepartment as o where o.id = ?", ids);
		} else {
			StringBuffer hql = new StringBuffer(256);
			hql.append("from LpsfDepartment as o where o.id in ");
			hql.append(StringUtil.getInExpFromArray(ids));
			commonDAO.delete(hql.toString());
		}
	}
}
