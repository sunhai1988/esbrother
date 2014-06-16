package com.esbrother.system.dao.role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.esbrother.system.entity.role.LpsfMasterplatemenu;
import com.esbrother.system.form.MasterForm;
import com.esbrother.system.spring.BaseBO;
import com.esbrother.system.util.Node;
import com.esbrother.system.util.Recursion;
import com.esbrother.system.util.StringUtil;

public class LpsfMasterDaoImpl extends BaseBO implements LpsfMasterDao {

	public List queryMaster(String or, String rp, MasterForm form,
			String fatherMasterplateCode) {
		StringBuffer str = new StringBuffer();
		str.append("select * from lpsf_masterplatemenu where 1=1 ");
		if (form.getMasterName() != null) {
			str.append("and masterplate_name like '%" + form.getMasterName()
					+ "%'");
		}
//		str.append(" and fatherMasterplateCode='" + fatherMasterplateCode
//						+ "'");
		List list = commonDAO.queryForList(str.toString(), form);
		return list;
	}

	public LpsfMasterplatemenu queryById(String id) {
		LpsfMasterplatemenu of = (LpsfMasterplatemenu) ((List) commonDAO
				.query(" from LpsfMasterplatemenu as o where o.id='" + id + "'"))
				.get(0);
		return of;
	}

	public void addMaster(LpsfMasterplatemenu lm) {
		if (lm.getRootId() == 0) {
			int num = getTreeNum();
			lm.setRootId(num + 1);
		}
		commonDAO.saveOrUpdate(lm);
	}

	public String queryTreeone(String id) {
		List<LpsfMasterplatemenu> list;
		if (id == null) {
			id = "0";
			list = (List<LpsfMasterplatemenu>) commonDAO
					.query("from LpsfMasterplatemenu");
		} else {
			list = (List<LpsfMasterplatemenu>) commonDAO
					.query("from LpsfMasterplatemenu where fathermasterplatecode='"
							+ id + "'");
		}
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			LpsfMasterplatemenu au = list.get(i);
			if (au.getFathermasterplatecode().equals(id)) {
				str += "{\"id\":\"" + au.getId()
						+ "\",\"state\":\"closed\",\"text\":\""
						+ au.getMasterplateName() + "\" ";
				if (au.getFathermasterplatecode().equals("0")) {
					str += ",\"children\":[";
					str += "]";
				}
				str += "   }";
			} else {
				str += "{\"id\":\"" + au.getId()
						+ "\",\"state\":\"closed\",\"text\":\""
						+ au.getMasterplateName() + "\" " + "   }";
			}
			if (i < list.size() - 1) {
				str += ",";
			}
		}
		return str;
	}

	public String queryTreetwo(String num) {
		List<Node> listNode = new ArrayList<Node>();
		StringBuffer sql = new StringBuffer();
		sql.append("from LpsfMasterplatemenu as l ");
		if (!num.equals("undefined")) {
			sql.append(" where l.issystemmaterplate='" + num + "'");
		}
		List<LpsfMasterplatemenu> list = (List<LpsfMasterplatemenu>) commonDAO
				.query(sql.toString());
		for (LpsfMasterplatemenu l : list) {
			Node node = new Node();
			node.setParentId(Integer.valueOf(l.getFathermasterplatecode()));
			node.setNodeId(Integer.valueOf(l.getRootId()));
			node.setTextName(l.getMasterplateName());
			listNode.add(node);
		}
		Recursion r = new Recursion();
		String str = r.recursionTree(listNode, new Node(1, 0));
		String trstStr = r.modifyStrToTree(str);
		return trstStr;
	}

	private synchronized int getTreeNum() {
		List list = commonDAO
				.queryForList("select max(root_id) as num from lpsf_masterplatemenu");
		Map map = (Map) list.get(0);
		if (map.get("num") != null) {
			Integer num = (Integer) map.get("num");
			return num;
		}
		return 1;
	}

	public void delete(String[] ids) {
		if (ids.length == 1) {
			commonDAO.delete("from LpsfMasterplatemenu as lm where lm.id = ?",
					ids);
		} else {
			StringBuffer hql = new StringBuffer(256);
			hql.append("from LpsfMasterplatemenu as lm where lm.id in ");
			hql.append(StringUtil.getInExpFromArray(ids));
			commonDAO.delete(hql.toString());
		}
	}
}
