package com.esbrother.system.dao.role;

import java.util.List;
import com.esbrother.system.entity.role.LpsfPosition;
import com.esbrother.system.form.PositionForm;

public interface LpsfPositionDao {
	public List queryPosition1(String order, String rp, PositionForm form);

	public void saveOrUpdatePosition(LpsfPosition lp);

	public LpsfPosition findByIdPosition(String id);

	public LpsfPosition findByPosition(String id);

	public List queryCompany1();
	
	public String queryEquipCompany(String id) throws Exception;

	public void deletePosition(String[] ids);
}
