package com.esbrother.system.action.role;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.esbrother.system.dao.role.LpsfMasterDao;
import com.esbrother.system.entity.role.LpsfMasterplatemenu;
import com.esbrother.system.form.MasterForm;
import com.esbrother.system.util.HtmlToJson;
import com.esbrother.system.util.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MasterAction extends ActionSupport implements ModelDriven {
	private String order;
	private String sort;
	private LpsfMasterplatemenu lm;
	private String id;
	private MasterForm form = new MasterForm();
	private LpsfMasterDao lpsfMasterDao;
	private String num;
	private String fatherMasterplateCode;

	public String queryMaster() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List list = null;
		try {
			list = lpsfMasterDao.queryMaster(order, sort, form,
					fatherMasterplateCode);
			output = JsonSerializer.serialize_tree(list,
					"fatherMasterplateCode", "1");
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String saveOrUpdateMaster() {
		try {
			lpsfMasterDao.addMaster(lm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}

	public String queryByIdMaster() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		String result = null;
		try {
			LpsfMasterplatemenu result1 = lpsfMasterDao.queryById(id);
			output = HtmlToJson.toHtmlObjectone(result1);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String queryTree() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		String result = null;
		try {
			output = lpsfMasterDao.queryTreetwo(num);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String deleteMaster() throws Exception {
		String[] ids = id.split(":");
		lpsfMasterDao.delete(ids);
		return Action.NONE;
	}

	public Object getModel() {
		return form;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public LpsfMasterDao getLpsfMasterDao() {
		return lpsfMasterDao;
	}

	public void setLpsfMasterDao(LpsfMasterDao lpsfMasterDao) {
		this.lpsfMasterDao = lpsfMasterDao;
	}

	public LpsfMasterplatemenu getLm() {
		return lm;
	}

	public void setLm(LpsfMasterplatemenu lm) {
		this.lm = lm;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getFatherMasterplateCode() {
		return fatherMasterplateCode;
	}

	public void setFatherMasterplateCode(String fatherMasterplateCode) {
		this.fatherMasterplateCode = fatherMasterplateCode;
	}

}
