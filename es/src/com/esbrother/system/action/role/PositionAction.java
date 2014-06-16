package com.esbrother.system.action.role;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.esbrother.system.dao.role.LpsfPositionDao;
import com.esbrother.system.entity.role.LpsfPosition;
import com.esbrother.system.form.PositionForm;
import com.esbrother.system.util.HtmlToJson;
import com.esbrother.system.util.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PositionAction extends ActionSupport implements ModelDriven {
	private String order;
	private String sort;
	private LpsfPositionDao positionDao;
	private LpsfPosition lp;
	private PositionForm form = new PositionForm();
	private String id;
	private String json;

	public String queryPosition1() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = positionDao.queryPosition1(order, sort, form);
			output = JsonSerializer.serialize1(result);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String addPosition() {
		positionDao.saveOrUpdatePosition(lp);
		return NONE;
	}

	public String queryByIdAction() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		String result = null;
		try {
			LpsfPosition result1 = positionDao.findByIdPosition(id);
			output = HtmlToJson.toHtmlObjectone(result1);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String queryByPosition() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		String result = null;
		try {
			LpsfPosition result1 = positionDao.findByPosition(id);
			output = HtmlToJson.toHtmlObjectone(result1);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String queryCompany1() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = positionDao.queryCompany1();
			output = "[" + JsonSerializer.serializetoList(result) + "]";
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String deletePosition() throws Exception {
		String[] args = id.split(":");
		positionDao.deletePosition(args);
		return Action.NONE;
	}
	
	public void queryEquipCompany() throws Exception {
		String output;
		try {
			output = positionDao.queryEquipCompany(id);
			json = "{\"suc\":\"1\", \"msg\":\"" + output + "\"}";
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		sendMsg(json);
	}
	
	public void sendMsg(String content) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(content);
	}

	public Object getModel() {
		return form;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
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

	public LpsfPositionDao getPositionDao() {
		return positionDao;
	}

	public void setPositionDao(LpsfPositionDao positionDao) {
		this.positionDao = positionDao;
	}

	public LpsfPosition getLp() {
		return lp;
	}

	public void setLp(LpsfPosition lp) {
		this.lp = lp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
