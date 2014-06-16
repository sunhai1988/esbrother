package com.esbrother.system.dao.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.esbrother.system.entity.user.LpsfUser;
import com.esbrother.system.form.UserForm;
import com.esbrother.system.spring.BaseBO;
import com.esbrother.system.util.DesUtils;
import com.esbrother.system.util.MD5Util;
import com.esbrother.system.util.Node;
import com.esbrother.system.util.Recursion;
import com.esbrother.system.util.StringUtil;

public class UserDaoImpl extends BaseBO implements UserDao {

	private String pageDelayTime;
	DesUtils des = new DesUtils();

	public String GetPageDelayTime() {
		return pageDelayTime;
	}

	public void setPageDelayTime(String pageDelayTime) {
		this.pageDelayTime = pageDelayTime;
	}

	public List queryUser(String roder, String rp, UserForm form) {
		StringBuffer hql = new StringBuffer();
		hql.append("select lu.id,lu.type,lp.position_name,de.dept_name,lu.user_name,");
		hql.append("lu.user_sex,lu.remark,lu.prohibition,lu.ming,lc.company_name from ");
		hql.append("lpsf_user as lu left outer join lpsf_position as lp on lu.position_id");
		hql.append("=lp.id left outer join lpsf_department de on lu.department_id=de.id ");
		hql.append("left outer join lpsf_company as lc on lu.company_id=lc.id ");
		if (form.getDept_name() != null) {
			hql.append("and de.dept_name like '%" + form.getDept_name() + "%'");
		}
		if (form.getPosition_name() != null
				&& !"".equals(form.getPosition_name())) {
			hql.append("and lp.position_name like '%" + form.getPosition_name()
					+ "%'");
		}
		if (form.getUser_name() != null && !"".equals(form.getUser_name())) {
			hql.append("and lu.user_name like '%" + form.getUser_name() + "%'");
		}

		if (form.getUser_sex() != null && !"".equals(form.getUser_sex())) {
			hql.append("and lu.user_sex like '%" + form.getUser_sex() + "%'");
		}

		if (form.getProhibition() != null && !"".equals(form.getProhibition())) {
			hql.append("and lu.prohibition like '%" + form.getProhibition()
					+ "%'");
		}
		List list = commonDAO.queryForList(hql.toString(), form);
		return list;
	}

	public LpsfUser queryById(String id) {
		LpsfUser of = (LpsfUser) ((List) commonDAO
				.query(" from LpsfUser as lu where lu.id='" + id + "'"))
				.get(0);
		return of;
	}

	public void delUser(String[] ids) throws Exception {
		if (ids.length == 1) {
			commonDAO.delete("from LpsfUser as lu where lu.id = ?", ids);
			commonDAO.delete("from LpsfUserUsers as luu where luu.userId = ?",
					ids);
		} else {
			StringBuffer hql = new StringBuffer(256);
			hql.append("from LpsfUser as lu where lu.id in ");
			hql.append(StringUtil.getInExpFromArray(ids));
			commonDAO.delete(hql.toString());
			StringBuffer hql2 = new StringBuffer(256);
			hql2.append("from LpsfUserUsers as luu where luu.userId in ");
			hql2.append(StringUtil.getInExpFromArray(ids));
			commonDAO.delete(hql2.toString());
		}
	}

	public void addDesUser(LpsfUser userinfo) throws Exception {
		commonDAO.saveOrUpdate(userinfo);
	}

	public List queryPosition() {
		List list = commonDAO
				.queryForList("select id,position_name from lpsf_position");
		return list;
	}

	public List queryDepartment() {
		List list = commonDAO
				.queryForList("select id,dept_name from lpsf_department");
		return list;
	}

	public List validator(String name, String pass) {
		List list = (List) commonDAO
				.query(" from LpsfUser as lu where lu.user_name='"
						+ name + "'" + " and lu.user_pass='" + pass + "'");
		return list;
	}

	public int changePass(String newpass, LpsfUser user) {
		List list = commonDAO.queryForList("select * from lpsf_user where id='"
				+ user.getId() + "'");
		if (!list.isEmpty()) {
			user.setUser_pass(newpass);
			commonDAO.saveOrUpdate(user);
			return 1;
		} else {
			return 0;
		}
	}

	public int queryByName(LpsfUser uf) {
		List list = commonDAO
				.queryForList("select * from lpsf_user where user_name='"
						+ uf.getUser_name() + "'");
		if (list.size() == 0) {
			String md5Pass = MD5Util.getMD5Str(uf.getUser_pass());
			uf.setUser_pass(md5Pass);
			commonDAO.save(uf);
			return 1;
		} else {
			return 0;
		}
	}

	public String userIdqueryMenu(String id) {
		List<Node> listNode = new ArrayList<Node>();
		String sql = "SELECT l.fatherMasterplateCode,l.root_id,l.pageURL,l.masterplate_name,l.id FROM lpsf_masterplatemenu l INNER JOIN lpsf_function_stencil_operate ls ON ls.stencil_id=l.ID INNER JOIN  lpsf_role_limit lr ON ls.operate_id=lr.limit_id INNER JOIN  lpsf_user_role lur ON lur.role_id=lr.role_id INNER JOIN lpsf_user_users lp ON lp.users_id=lur.user_group_id AND user_id = '"
				+ id
				+ "' where l.isSystemMaterplate='0' group by l.id ORDER BY root_id";
		List list = commonDAO.queryForList(sql);
		try {
			for (int i = 0; i < list.size(); i++) {
				Map map = (Map) list.get(i);
				Node node = new Node();
				node.setParentId(Integer.valueOf(map.get(
						"fatherMasterplateCode").toString()));
				node.setNodeId(Integer.valueOf(map.get("root_id").toString()));
				// 对公司名称进行加密
				node.setUrl(map.get("pageURL").toString() + "?companyname="
						+ des.encrypt(map.get("masterplate_name").toString()));
				node.setMenuId(map.get("id").toString());
				node.setTextName(map.get("masterplate_name").toString());
				listNode.add(node);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Recursion r = new Recursion();
		String str = r.recursionTreeUserIdQueryMenu(listNode, new Node(1, 0));
		String trstStr = r.modifyStrToTreeUserIdQueryMenu(str);
		return trstStr;
	}
	
	// 按钮权限控制
	public List btUesrByUserIdPage(String id, String pageName) {
		String sql = "SELECT l.fatherMasterplateCode,l.root_id,l.pageURL,l.masterplate_name,l.id FROM lpsf_masterplatemenu l INNER JOIN lpsf_function_stencil_operate ls ON ls.stencil_id=l.ID INNER JOIN  lpsf_role_limit lr ON ls.operate_id=lr.limit_id INNER JOIN  lpsf_user_role lur ON lur.role_id=lr.role_id INNER JOIN lpsf_user_users lp ON lp.users_id=lur.user_group_id AND user_id = '"
				+ id
				+ "' where l.fatherMasterplateCode=(select root_id from lpsf_masterplatemenu where pageURL='"
				+ pageName + "') group by l.id ORDER BY root_id";
		List list = commonDAO.queryForList(sql);
		return list;
	};

	public List queryLog(UserForm form) {
		StringBuffer hql = new StringBuffer();
		hql.append("select * from log4j where 1=1 ");
		if (form.getStime() != null && !"".equals(form.getStime())) {
			hql.append(" and log_date>='" + form.getStime() + "'");
		}
		if (form.getEtime() != null && !"".equals(form.getEtime())) {
			hql.append(" and log_date <='" + form.getEtime() + "'");
		}
		hql.append(" order by log_date desc");
		List list = (List) commonDAO.queryForList(hql.toString(), form);
		return list;
	}

	public List<String> getUserAction(String id) {
		List<String> strlist = new ArrayList<String>();
		String sql = "SELECT l.pageurl FROM lpsf_masterplatemenu l INNER JOIN lpsf_function_stencil_operate ls ON ls.stencil_id=l.ID INNER JOIN  lpsf_role_limit lr ON ls.operate_id=lr.limit_id INNER JOIN  lpsf_user_role lur ON lur.role_id=lr.role_id INNER JOIN lpsf_user_users lp ON lp.users_id=lur.user_group_id AND user_id = '"
				+ id
				+ "' where l.isSystemMaterplate='1' and l.pageURL!='null' group by l.id ORDER BY root_id";
		List list = commonDAO.queryForList(sql);
		for (int i = 0; i < list.size(); i++) {
			Map map = (Map) list.get(i);
			strlist.add(map.get("pageurl").toString());
		}
		return strlist;
	}

	public String buqueryMenu(String id) throws Exception {
		List<Node> listNode = new ArrayList<Node>();
		String sql = "SELECT ltt.fatherTemplateCode,ltt.root_id,lcm.url,ltt.template_name,ltt.id,lcm.company_id FROM lpsf_trade_template ltt INNER JOIN lpsf_company_menu lcm ON ltt.id=lcm.template_id INNER JOIN lpsf_company lc ON lcm.company_id=lc.id inner join lpsf_user lu on lc.id = lu.company_id AND lu.id = '"
				+ id
				+ "' where ltt.isSystemTemplate='0' group by ltt.id ORDER BY root_id";
		List list = commonDAO.queryForList(sql);
		try {
			for (int i = 0; i < list.size(); i++) {
				Map map = (Map) list.get(i);
				Node node = new Node();
				node.setParentId(Integer.valueOf(map.get("fatherTemplateCode")
						.toString()));
				node.setNodeId(Integer.valueOf(map.get("root_id").toString()));
				// 对公司名称进行加密
				StringBuffer url = new StringBuffer();
				url.append(map.get("url").toString() + "?companyid=");
				url.append(des.encrypt(map.get("company_id").toString()));
				url.append("&template_name=");
				url.append(des.encrypt(map.get("template_name").toString()));
				node.setUrl(url.toString());
				node.setMenuId(map.get("id").toString());
				node.setTextName(map.get("template_name").toString());
				listNode.add(node);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Recursion r = new Recursion();
		String str = r.recursionTreeUserIdQueryMenu(listNode, new Node(1, 0));
		String trstStr = r.modifyStrToTreeUserIdQueryMenu(str);
		return trstStr;
	}

	public String getReportHomePage(LpsfUser user) throws Exception {
		String type = "";
		StringBuffer sql = new StringBuffer();
		sql.append("select lc.type from lpsf_company lc");
		sql.append(" where lc.id='" + user.getCompanyId() + "'");
		List list = commonDAO.queryForList(sql.toString());
		if (list.isEmpty()) {
			return type;
		} else {
			Map map = (Map) list.get(0);
			type = map.get("type").toString();
			return type;
		}
	}

	public String getHomePageImage(String companyid, String templateName)
			throws Exception {
		String image = "";
		StringBuffer sql = new StringBuffer();
		sql.append("select industry_picurl,storage_location");
		sql.append(" from lpsf_industry_home where id=");
		sql.append(" (select lcm.industry_home_id from lpsf_company");
		sql.append(" lc INNER JOIN lpsf_company_menu lcm");
		sql.append(" on lc.id=lcm.company_id INNER JOIN lpsf_trade_template");
		sql.append(" ltt on lcm.template_id=ltt.id");
		sql.append(" where lc.id='" + companyid + "'");
		sql.append(" and ltt.template_name='" + templateName + "')");
		List list = commonDAO.queryForList(sql.toString());
		if (list.isEmpty()) {
			return image;
		} else {
			Map map = (Map) list.get(0);
			image = "../../upload/" + map.get("storage_location").toString()
					+ "/" + map.get("industry_picurl").toString();
			return image;
		}
	}

}
