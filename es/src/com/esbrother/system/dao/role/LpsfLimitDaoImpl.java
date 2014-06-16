package com.esbrother.system.dao.role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.esbrother.system.entity.role.LpsfFunctionStencilOperate;
import com.esbrother.system.entity.role.LpsfLimit;
import com.esbrother.system.form.QueryLimitForm;
import com.esbrother.system.spring.BaseBO;
import com.esbrother.system.util.Node;
import com.esbrother.system.util.Recursion;
import com.esbrother.system.util.StringUtil;

public class LpsfLimitDaoImpl extends BaseBO implements LpsfLimitDao {

	public List queryRole(String order, String rp, QueryLimitForm form) {
		StringBuffer hql = new StringBuffer();
		hql.append("Select * from lpsf_limit where 1=1 ");
		if (form.getLimitWay() != null) {
			hql.append("and limitWay like '%" + form.getLimitWay() + "%'");
		}
		if (form.getLimitDeclare() != null) {
			hql.append("and limitDeclare like '%" + form.getLimitDeclare()
					+ "%'");
		}
		if (form.getLimitRemark() != null) {
			hql.append("and limitRemark like '%" + form.getLimitRemark() + "%'");
		}
		hql.append("ORDER BY ? ?");
		List list = commonDAO.queryForList(hql.toString(), new Object[] {
				order, rp }, form);
		return list;
	}

	public void addLimit(LpsfLimit lr) {
		commonDAO.saveOrUpdate(lr);
	}

	public LpsfLimit queryById(String id) {
		LpsfLimit of = (LpsfLimit) ((List) commonDAO
				.query(" from LpsfLimit as o where o.id='" + id + "'")).get(0);
		return of;
	}

	public void deleteLimit(String[] ids) {
		if (ids.length == 1) {
			commonDAO.delete("from LpsfLimit as o where o.id = ?", ids);
		} else {
			StringBuffer hql = new StringBuffer(256);
			hql.append("from LpsfLimit as o where o.id in ");
			hql.append(StringUtil.getInExpFromArray(ids));
			commonDAO.delete(hql.toString());
		}
	}

	public String LimitqueryMenu(String id) {
		List<Node> listNode = new ArrayList<Node>();
		List list1 = commonDAO
				.queryForList("select l.fatherMasterplateCode,l.root_id,l.id,l.masterplate_name ,p.operate_id from lpsf_masterplatemenu as l left join lpsf_function_stencil_operate p on l.id=p.stencil_id and p.operate_id='"
						+ id + "'");
		for (int i = 0; i < list1.size(); i++) {
			Map map = (Map) list1.get(i);
			Node node = new Node();
			node.setParentId(Integer.valueOf((String) map
					.get("fatherMasterplateCode")));
			node.setNodeId((Integer) map.get("root_id"));
			node.setMenuId((String) map.get("id"));
			node.setTextName((String) map.get("masterplate_name"));
			node.setPdId((String) map.get("operate_id"));
			listNode.add(node);
		}
		Recursion r = new Recursion();
		String str = r.recursionZTreeMenu(listNode, new Node(1, 0));
		String trstStr = r.modifyStrToZTreeMenu(str);
		return trstStr;
	}

	public List LimitqueryOperate(String id) {
		List list = commonDAO
				.queryForList("select * from lpsf_function_stencil_operate where operate_id='"
						+ id + "'");
		return list;
	}

	public void LimitAddMenu(LpsfFunctionStencilOperate functionStencilOperate) {
		commonDAO.saveOrUpdate(functionStencilOperate);
	}

	public void limitAddAction(String id, String ids) {
		String[] strId = ids.split(",");
		commonDAO.delete(
				"from LpsfFunctionStencilOperate as us where us.operateId = ?",
				id);
		for (int i = 0; i < strId.length; i++) {
			LpsfFunctionStencilOperate f = new LpsfFunctionStencilOperate();
			f.setOperateId(id);
			f.setStencilId(strId[i]);
			commonDAO.save(f);
		}
	}

}
