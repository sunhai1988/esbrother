package com.esbrother.system.dao.user;

import java.util.List;
import com.esbrother.system.entity.user.LpsfUser;
import com.esbrother.system.form.UserForm;

public interface UserDao {

	public List queryUser(String roder, String rp, UserForm form);

	public LpsfUser queryById(String id);

	void delUser(String[] ids) throws Exception;

	void addDesUser(LpsfUser userinfo) throws Exception;

	public List queryPosition();

	public List queryDepartment();

	public List validator(String name, String pass);

	public int queryByName(LpsfUser uf);

	public String userIdqueryMenu(String id);
	
	//按钮权限控制
	public List btUesrByUserIdPage(String id,String pageName);

	public List queryLog(UserForm form);

	public int changePass(String newpass, LpsfUser user);

	public List<String> getUserAction(String id);
	
	public String buqueryMenu(String id) throws Exception;
	
	String GetPageDelayTime() throws Exception;
	
	String getReportHomePage(LpsfUser user) throws Exception;
	
	String getHomePageImage(String companyid,String template_name) throws Exception;
}
