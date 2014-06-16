package com.esbrother.system.dao.role;

import java.util.List;

import com.esbrother.system.entity.role.LpsfDepartment;
import com.esbrother.system.form.DeptForm;

public interface LpsfDeptDao {
	public List queryDept(String order, String rp, DeptForm from);

	public void addDept(LpsfDepartment dp);

	public LpsfDepartment queryById(String id);

	public List queryComp();

	public void deleteDept(String[] ids);
}
