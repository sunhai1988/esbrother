package com.esbrother.system.util;

public class StringUtil {
	public static String getInExpFromArray(String[] candidateId) {
		String hql = null;
		if (candidateId.length != 0) {
			StringBuilder sb = new StringBuilder("(");

			for (String id : candidateId) {
				sb.append("'").append(id).append("',");
			}

			sb.deleteCharAt(sb.length() - 1);
			sb.append(")");
			hql = sb.toString();
		}
		return hql;
	}

	public static String[] dateTotime(String date) {
		String[] str = date.split(",");
		return str;
	}
}
