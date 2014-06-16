package com.esbrother.system.dao.role;

import java.util.List;
import com.esbrother.system.entity.role.LpsfUserRole;
import com.esbrother.system.form.UserRoleForm;

public interface UserRoleDao {
	public List queryUserRole(String order, String rp, UserRoleForm from);

	public void addUserRole(LpsfUserRole ur);

	public LpsfUserRole queryById(String id);

	public List queryUsers();

	public List queryRole();

	public String queryByGroupRole(String id);

	public void addGroupToRole(String str, String id);
}
