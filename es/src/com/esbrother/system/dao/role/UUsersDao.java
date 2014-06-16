package com.esbrother.system.dao.role;

import java.util.List;
import com.esbrother.system.entity.role.LpsfUserUsers;
import com.esbrother.system.form.UUsersForm;

public interface UUsersDao {
	public List queryUUsers(String order, String rp, UUsersForm from);

	public void addUUsers(LpsfUserUsers luu);

	public LpsfUserUsers queryById(String id);

	public List queryUsers1();

	public List queryUser1();

	public String queryByUserGroup(String id);

	public void addUserToGroup(String str, String id);
	
	public String queryCompanyByRadio();
}
