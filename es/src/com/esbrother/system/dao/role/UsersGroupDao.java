package com.esbrother.system.dao.role;

import java.util.List;
import com.esbrother.system.entity.role.LpsfUsers;
import com.esbrother.system.form.UsersGroupForm;

public interface UsersGroupDao {

	public List queryUsersGroup(String roder, String rp, UsersGroupForm form);

	public LpsfUsers queryById(String id);

	void delUsersGroup(String[] ids) throws Exception;

	void addDesUsersGroup(LpsfUsers lu) throws Exception;

	public List queryRole1();
}
