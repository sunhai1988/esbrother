package com.esbrother.system.util;

public class Node {
	private int nodeId;
	private int parentId;
	private String textName;
	private String menuId;
	private String url;
	private String pdId;

	public Node(int nodeId, int parentId) {
		super();
		this.nodeId = nodeId;
		this.parentId = parentId;
	}

	public Node() {
		super();
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getTextName() {
		return textName;
	}

	public void setTextName(String textName) {
		this.textName = textName;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPdId() {
		return pdId;
	}

	public void setPdId(String pdId) {
		this.pdId = pdId;
	}

}
