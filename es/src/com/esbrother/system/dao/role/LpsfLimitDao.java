package com.esbrother.system.dao.role;

import java.util.List;

import com.esbrother.system.entity.role.LpsfFunctionStencilOperate;
import com.esbrother.system.entity.role.LpsfLimit;
import com.esbrother.system.form.QueryLimitForm;

public interface LpsfLimitDao {
	public List queryRole(String order, String rp, QueryLimitForm form);

	public void addLimit(LpsfLimit limit);

	public LpsfLimit queryById(String id);

	public void deleteLimit(String[] ids);

	public String LimitqueryMenu(String id);

	public List LimitqueryOperate(String id);

	public void LimitAddMenu(LpsfFunctionStencilOperate functionStencilOperate);

	public void limitAddAction(String id, String ids);
}
