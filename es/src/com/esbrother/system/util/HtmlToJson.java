package com.esbrother.system.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HtmlToJson {
	public final static Map<String, String> HTML_CHAR = new HashMap<String, String>();
	static {
		HTML_CHAR.put("\"", "'");
		HTML_CHAR.put("\n", "\\u000a");
	}

	public static String HtmlToJsonUtil(String exceptionTrace) {
		if (exceptionTrace.indexOf("'") != -1) {
			// 将单引号转义一下，因为JSON串中的字符串类型可以单引号引起来的
			exceptionTrace = exceptionTrace.replaceAll("'", "\\'");
		}
		if (exceptionTrace.indexOf("\"") != -1) {
			// 将双引号转义一下，因为JSON串中的字符串类型可以单引号引起来的
			exceptionTrace = exceptionTrace.replaceAll("\"", "\\\"");
		}

		if (exceptionTrace.indexOf("\r\n") != -1) {
			// 将回车换行转换一下，因为JSON串中字符串不能出现显式的回车换行
			exceptionTrace = exceptionTrace
					.replaceAll("\r\n", "\\u000d\\u000a");
		}
		if (exceptionTrace.indexOf("\n") != -1) {
			// 将换行转换一下，因为JSON串中字符串不能出现显式的换行
			exceptionTrace = exceptionTrace.replaceAll("\n", "\\u000a");
		}
		return exceptionTrace;
	}

	public static final StringBuilder toHTMLChar(String str) {
		if (str == null) {
			return new StringBuilder();
		}
		StringBuilder sb = new StringBuilder(str);
		char tempChar;
		String tempStr;
		for (int i = 0; i < sb.length(); i++) {
			tempChar = sb.charAt(i);
			if (HTML_CHAR.containsKey(Character.toString(tempChar))) {
				tempStr = (String) HTML_CHAR.get(Character.toString(tempChar));
				sb.replace(i, i + 1, tempStr);
				i += tempStr.length() - 1;
			}
		}
		return sb;
	}

	public static String toHtmlObject(Object c) throws Exception {
		StringBuffer bf = new StringBuffer();
		String entityName = "";
		Class classType = c.getClass();
		Field[] fields = classType.getDeclaredFields();
		bf.append("{\"list\":{");
		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();
			entityName += fieldName + ",";
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			Method getMethod = classType.getMethod(getMethodName,
					new Class[] {});
			Object value = getMethod.invoke(c, new Object[] {});
			bf.append("\"" + fieldName + "\":");
			if (value == null) {
				bf.append("\"" + "" + "\"");
			} else {
				bf.append("\"" + HtmlToJson.toHTMLChar(value.toString()) + "\"");
			}
			if (i != fields.length - 1) {
				bf.append(",");
			}
		}
		bf.append("},\"id\":\"" + entityName + "\"");
		bf.append("}");
		return bf.toString();
	}

	public static String toHtmlObjectone(Object c) throws Exception {
		StringBuffer bf = new StringBuffer();
		Class classType = c.getClass();
		Field[] fields = classType.getDeclaredFields();
		bf.append("{");
		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			Method getMethod = classType.getMethod(getMethodName,
					new Class[] {});
			Object value = getMethod.invoke(c, new Object[] {});
			bf.append("\"" + fieldName + "\":");
			if (value == null) {
				bf.append("\"" + "" + "\"");
			} else {
				bf.append("\"" + HtmlToJson.toHTMLChar(value.toString()) + "\"");
			}
			if (i != fields.length - 1) {
				bf.append(",");
			}
		}
		bf.append("}");
		return bf.toString();
	}
}
