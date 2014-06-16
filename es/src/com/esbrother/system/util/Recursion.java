package com.esbrother.system.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Recursion {

	public Recursion() {// 构造方法里初始化模拟List

	}

	StringBuffer returnStr = new StringBuffer();

	public String recursionFn(List list, Node node) {
		if (hasChild(list, node)) {
			returnStr.append("{id:");
			returnStr.append(node.getNodeId());
			returnStr.append(",parentId:");
			returnStr.append(node.getParentId());
			returnStr.append(",children:[");
			List childList = getChildList(list, node);
			Iterator it = childList.iterator();
			while (it.hasNext()) {
				Node n = (Node) it.next();
				recursionFn(list, n);
			}
			returnStr.append("]},");
		} else {
			returnStr.append("{id:");
			returnStr.append(node.getNodeId());
			returnStr.append(",parentId:");
			returnStr.append(node.getParentId());
			returnStr.append(",leaf:true},");
		}
		return returnStr.toString();
	}

	public String recursionTree(List<Node> list, Node node) {
		if (hasChild(list, node)) {
			returnStr.append("{\"isexpand\":");
			returnStr.append("\"false\"");
			returnStr.append(",\"id\":");
			returnStr.append("\"" + node.getNodeId() + "\"");
			returnStr.append(",\"state\":");
			returnStr.append("\"closed\"");
			returnStr.append(",\"text\":");
			returnStr.append("\"" + node.getTextName() + "\"");
			returnStr.append(",\"children\":[");
			List childList = getChildList(list, node);
			Iterator it = childList.iterator();
			while (it.hasNext()) {
				Node n = (Node) it.next();
				recursionTree(list, n);
			}
			returnStr.append("]},");
		} else {
			returnStr.append("{\"id\":");
			returnStr.append("\"" + node.getNodeId() + "\"");
			returnStr.append(",\"state\":");
			returnStr.append("\"closed\"");
			returnStr.append(",\"text\":");
			returnStr.append("\"" + node.getTextName() + "\"");
			returnStr.append(",\"leaf\":true},");
		}
		return returnStr.toString();
	}

	public String recursionTreeUserIdQueryMenu(List<Node> list, Node node) {
		if (hasChild(list, node)) {
			returnStr.append("{\"url\":");
			returnStr.append("\"" + node.getUrl() + "\"");
			returnStr.append(",\"menuId\":");
			returnStr.append("\"" + node.getMenuId() + "\"");
			returnStr.append(",\"state\":");
			returnStr.append("\"closed\"");
			returnStr.append(",\"text\":");
			returnStr.append("\"" + node.getTextName() + "\"");
			returnStr.append(",\"children\":[");
			List childList = getChildList(list, node);
			Iterator it = childList.iterator();
			while (it.hasNext()) {
				Node n = (Node) it.next();
				recursionTreeUserIdQueryMenu(list, n);
			}
			returnStr.append("]},");
		} else {
			returnStr.append("{\"url\":");
			returnStr.append("\"" + node.getUrl() + "\"");
			returnStr.append(",\"menuId\":");
			returnStr.append("\"" + node.getMenuId() + "\"");
			returnStr.append(",\"state\":");
			returnStr.append("\"closed\"");
			returnStr.append(",\"text\":");
			returnStr.append("\"" + node.getTextName() + "\"");
			returnStr.append(",\"isLeaf\":true},");
		}
		return returnStr.toString();
	}

	public String recursionTreeMenu(List<Node> list, Node node) {
		if (hasChild(list, node)) {
			returnStr.append("{\"menuId\":");
			returnStr.append("\"" + node.getMenuId() + "\"");
			returnStr.append(",\"id\":");
			returnStr.append("\"" + node.getNodeId() + "\"");
			returnStr.append(",\"state\":");
			returnStr.append("\"closed\"");
			returnStr.append(",\"text\":");
			returnStr.append("\"" + node.getTextName() + "\"");
			returnStr.append(",\"children\":[");
			List childList = getChildList(list, node);
			Iterator it = childList.iterator();
			while (it.hasNext()) {
				Node n = (Node) it.next();
				recursionTreeMenu(list, n);
			}
			returnStr.append("]},");
		} else {
			returnStr.append("{\"menuId\":");
			returnStr.append("\"" + node.getMenuId() + "\"");
			returnStr.append(",\"id\":");
			returnStr.append("\"" + node.getNodeId() + "\"");
			returnStr.append(",\"state\":");
			returnStr.append("\"closed\"");
			returnStr.append(",\"text\":");
			returnStr.append("\"" + node.getTextName() + "\"");
			returnStr.append(",\"leaf\":true},");
		}
		return returnStr.toString();
	}

	// 配合ztree写的
	public String recursionZTreeMenu(List<Node> list, Node node) {
		if (hasChild(list, node)) {
			returnStr.append("{\"menuId\":");
			returnStr.append("\"" + node.getMenuId() + "\"");
			returnStr.append(",\"id\":");
			returnStr.append("\"" + node.getNodeId() + "\"");
			returnStr.append(",\"state\":");
			returnStr.append("\"closed\"");
			returnStr.append(",\"text\":");
			returnStr.append("\"" + node.getTextName() + "\"");
			if (node.getPdId() != null) {
				returnStr.append(",\"checked\":");
				returnStr.append("true");
			}
			returnStr.append(",\"nodes\":[");
			List childList = getChildList(list, node);
			Iterator it = childList.iterator();
			while (it.hasNext()) {
				Node n = (Node) it.next();
				recursionZTreeMenu(list, n);
			}
			returnStr.append("]},");
		} else {
			returnStr.append("{\"menuId\":");
			returnStr.append("\"" + node.getMenuId() + "\"");
			returnStr.append(",\"id\":");
			returnStr.append("\"" + node.getNodeId() + "\"");
			returnStr.append(",\"state\":");
			returnStr.append("\"closed\"");
			returnStr.append(",\"text\":");
			returnStr.append("\"" + node.getTextName() + "\"");
			if (node.getPdId() != null) {
				returnStr.append(",\"checked\":");
				returnStr.append("true");
			}
			returnStr.append(",\"leaf\":true},");
		}
		return returnStr.toString();
	}

	public boolean hasChild(List list, Node node) { // 判断是否有子节点
		return getChildList(list, node).size() > 0 ? true : false;
	}

	public List getChildList(List list, Node node) { // 得到子节点列表
		List li = new ArrayList();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Node n = (Node) it.next();
			if (n.getParentId() == node.getNodeId()) {
				li.add(n);
			}
		}
		return li;
	}

	public String modifyStr(String returnStr) {
		return ("[" + returnStr + "]").replaceAll(",]", "]");
	}

	public String modifyStrToTree(String returnStr) {
		returnStr = returnStr
				.replace(
						"{\"isexpand\":\"false\",\"id\":\"1\",\"state\":\"closed\",\"text\":\"null\",\"children\":[",
						"");
		returnStr = ("[" + returnStr + "]").replaceAll(",]", "]");
		returnStr = returnStr.substring(0, returnStr.length() - 2);
		return returnStr;
	}

	public String modifyStrToTreeMenu(String returnStr) {
		returnStr = returnStr
				.replace(
						"{\"menuId\":\"null\",\"id\":\"1\",\"state\":\"closed\",\"text\":\"null\",\"children\":[",
						"");
		returnStr = ("[" + returnStr + "]").replaceAll(",]", "]");
		returnStr = returnStr.substring(0, returnStr.length() - 2);
		return returnStr;
	}

	public String modifyStrToZTreeMenu(String returnStr) {
		returnStr = returnStr
				.replace(
						"{\"menuId\":\"null\",\"id\":\"1\",\"state\":\"closed\",\"text\":\"null\",\"nodes\":[",
						"");
		returnStr = ("[" + returnStr + "]").replaceAll(",]", "]");
		returnStr = returnStr.substring(0, returnStr.length() - 2);
		return returnStr;
	}

	public String modifyStrToTreeUserIdQueryMenu(String returnStr) {
		returnStr = returnStr
				.replace(
						"{\"url\":\"null\",\"menuId\":\"null\",\"state\":\"closed\",\"text\":\"null\",\"children\":[",
						"");
		returnStr = ("[" + returnStr + "]").replaceAll(",]", "]");
		returnStr = returnStr.substring(0, returnStr.length() - 2);
		return returnStr;
	}

	public static void main(String[] args) {

	}
}
