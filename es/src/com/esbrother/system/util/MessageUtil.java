package com.esbrother.system.util;

public class MessageUtil {
	public static final String MESSAGE_OK = "成功";
	public static final String MESSAGE_ERROR = "失败";
	public static final String MESSAGE_QX = "权限不够";
	public static final String MESSAGE_LOGIN = "登录成功";

	public static String message(String mess) {
		String json = "{suc:1, msg:'" + mess + "'}";
		return json;
	}
}
