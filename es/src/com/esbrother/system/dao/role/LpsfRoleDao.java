package com.esbrother.system.dao.role;

import java.util.List;
import com.esbrother.system.entity.role.LpsfRole;
import com.esbrother.system.entity.role.LpsfRoleLimit;
import com.esbrother.system.form.RoleForm;

public interface LpsfRoleDao {
	public List queryRole(String order, String rp, RoleForm form);

	public List RolequeryLimit();

	public void addRole(LpsfRole lr);

	public LpsfRole queryById(String id);

	public List queryByIdLimit(String id);

	public void deleteRole(String[] ids);

	public void RoleAddLimit(LpsfRoleLimit rl);

	public String queryByRoleId(String id);

	public void addLimitToGroup(String str, String id);
}
