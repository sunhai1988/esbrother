package com.esbrother.system.dao.role;

import java.util.List;
import com.esbrother.system.entity.role.LpsfMasterplatemenu;
import com.esbrother.system.form.MasterForm;

public interface LpsfMasterDao {
	public List queryMaster(String or, String rp, MasterForm form,
			String fatherMasterplateCode);

	public LpsfMasterplatemenu queryById(String id);

	public void addMaster(LpsfMasterplatemenu lm);

	public String queryTreeone(String id);

	public String queryTreetwo(String num);

	public void delete(String[] ids);

}
