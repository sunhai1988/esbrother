package com.esbrother.system.action.role;

//import java.awt.Color;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
//import java.io.StringReader;
import java.util.List;
//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
//import org.apache.struts2.interceptor.ServletRequestAware;
//import org.apache.struts2.interceptor.ServletResponseAware;
//import com.lowagie.text.Document;
//import com.lowagie.text.Element;
//import com.lowagie.text.Font;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.html.simpleparser.HTMLWorker;
//import com.lowagie.text.html.simpleparser.StyleSheet;
//import com.lowagie.text.pdf.BaseFont;
//import com.lowagie.text.pdf.PdfWriter;
//import com.lowagie.text.rtf.RtfWriter2;
import com.esbrother.system.dao.user.UserDao;
import com.esbrother.system.dao.role.UsersGroupDao;
import com.esbrother.system.entity.role.LpsfUsers;
import com.esbrother.system.entity.user.LpsfUser;
import com.esbrother.system.form.UserForm;
import com.esbrother.system.form.UsersGroupForm;
import com.esbrother.system.util.HtmlToJson;
import com.esbrother.system.util.JsonSerializer;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UsersGroupAction extends ActionSupport implements ModelDriven {
	private InputStream pdfStream;
	private String order;
	private String sort;
	private String id;
	private UsersGroupDao usersgroupDao;
	UsersGroupForm form = new UsersGroupForm();
	private LpsfUsers lu;
	private String type;

	public String queryUsersGroup() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = usersgroupDao.queryUsersGroup(sort, order, form);
			output = JsonSerializer.serialize1(result);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public String addUsersGroup() throws Exception {
		try {
			usersgroupDao.addDesUsersGroup(lu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}

	public String deleteUsersGroup() throws Exception {
		try {
			String[] args = id.split(":");
			usersgroupDao.delUsersGroup(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			LpsfUsers result1 = usersgroupDao.queryById(id);
			output = HtmlToJson.toHtmlObjectone(result1);
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

//	public String generateContract() throws Exception {
//		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//		Document document = new Document(PageSize.A4);
//		RtfWriter2.getInstance(document, buffer);
//		document.open();
//		BaseFont macintosh = BaseFont.createFont("STSong-Light",
//				"UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//		// 标题字体风格
//		Font ThemeFont = new Font(macintosh, 18, Font.BOLD);
//		// 设置标题字体的颜色
//		ThemeFont.setColor(Color.RED);
//		// 正文字体风格
//		Font bodyFont = new Font(macintosh, 14, Font.NORMAL);
//		// 设置正文字体的颜色
//		bodyFont.setColor(56, 94, 15);
//		// 创建主题的Phrases对象
//		Paragraph theme = new Paragraph("主标题");
//		// 将设置好的字体添加到主题的短句上
//		theme.setAlignment(Element.ALIGN_CENTER);
//		theme.setFont(ThemeFont);
//		// 将Phrases添加到document文档中
//		document.add(theme);
//
//		// 设置中文字体
//		Paragraph context = new Paragraph();
//		context.setAlignment(Element.ALIGN_LEFT);
//		// 设置正文字体的颜色
//		context.setFont(bodyFont);
//		// 离上一段落（标题）空的行数
//		context.setSpacingBefore(3);
//		// 设置第一行空的列数
//		context.setFirstLineIndent(20);
//		String bodyText = "<p>Java程序通过流来完成输入/输出，它是生产或消费信息的抽象。<p/>"
//				+ "流通过Java的输入/输出系统与物理设备链接，尽管与它们链接的物理设备不尽相同，"
//				+ "但是所有流的行为具有同样的方式，这样，相同的输入/输出类和方法适用于所有类型的外部设备，"
//				+ "这意味着一个输入流能够抽象多种不同类型的输入：从磁盘文件，从键盘或从网络套接字，"
//				+ "同样，一个输出流可以输出到控制台，磁盘文件或相连的网络。"
//				+ "流是处理输入/输出的一个洁净的方法，例如它不需要代码理解键盘和网络的不同。"
//				+ "Java中流的实现是基于java.io包定义的类层次结构的。";
//		StyleSheet ss = new StyleSheet();
//		List htmlList = HTMLWorker.parseToList(new StringReader(bodyText), ss);
//		for (int i = 0; i < htmlList.size(); i++) {
//			com.lowagie.text.Element e = (com.lowagie.text.Element) htmlList
//					.get(i);
//			context.add(e);
//		}
//		document.add(context);
//		document.close();
//		this.pdfStream = new ByteArrayInputStream(buffer.toByteArray());
//		buffer.close();
//		return SUCCESS;
//	}

	public String queryRole1() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output;
		List result = null;
		try {
			result = usersgroupDao.queryRole1();
			output = "[" + JsonSerializer.serializetoList(result) + "]";
		} catch (Exception e) {
			e.printStackTrace();
			output = "";
		}
		out.write(output);
		out.close();
		return Action.NONE;
	}

	public Object getModel() {
		return form;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public InputStream getPdfStream() {
		return pdfStream;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UsersGroupDao getUsersgroupDao() {
		return usersgroupDao;
	}

	public void setUsersgroupDao(UsersGroupDao usersgroupDao) {
		this.usersgroupDao = usersgroupDao;
	}

	public LpsfUsers getLu() {
		return lu;
	}

	public void setLu(LpsfUsers lu) {
		this.lu = lu;
	}

	public String getSort() {
		return sort;
	}

}
