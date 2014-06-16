package com.esbrother.system.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.esbrother.system.hibernate.PageInfo;
import com.esbrother.system.hibernate.QueryResult;

public class JsonSerializer {
	static Log log = LogFactory.getLog(JsonSerializer.class);

	public static String serialize(List list) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		StringBuilder stringBuilder = new StringBuilder(1024);
		if ((null != list) && (list.size() != 0)) {
			Map lastMap = (Map) list.get(list.size() - 1);
			if (lastMap.get("count") != null) {
				stringBuilder.append("{ total: ")
						.append(lastMap.get("pgcount"));
				stringBuilder.append(", page:").append(lastMap.get("pgnum"));
				stringBuilder.append(", records:").append(lastMap.get("count"))
						.append(", rows: [");
				list.remove(list.size() - 1);
			} else {
				stringBuilder
						.append("{ total: 2, page: 1, records: 11, rows: [");
			}
			for (int i = 0; i < list.size(); i++) {
				Map map = (Map) list.get(i);
				stringBuilder.append("{id:'");
				if (null != map) {
					stringBuilder.append(PropertyUtils.getProperty(map, "id"));
					stringBuilder.append("',cell:[");
				}
				Iterator it = map.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();
					String key = "";
					String value = "";
					if (entry.getKey() != null)
						key = entry.getKey().toString();
					if (entry.getValue() != null) {
						value = entry.getValue().toString();
					}
					if ((!key.equals("serialVersionUID"))
							&& (!key.equals("ID"))) {
						if ((value != "") && (value != null))
							stringBuilder.append("'" + value + "'");
						if (it.hasNext()) {
							stringBuilder.append(",");
						}
					}
				}
				stringBuilder.append("]}");
				if (i < list.size() - 1) {
					stringBuilder.append(",");
				}
			}
		}
		stringBuilder.append("]}");
		return stringBuilder.toString();
	}

	public static String serializeTo(QueryResult result) throws Exception {
		Collection objs = result.getData();
		PageInfo page = result.getPageInfo();
		StringBuilder stringBuilder = new StringBuilder(1024);
		if ((null != objs) && (objs.size() != 0)) {
			if (page != null) {
				stringBuilder.append("{ total: ").append(page.getPgcount());
				stringBuilder.append(", page:").append(page.getPgsize());
				stringBuilder.append(", records:").append(page.getCount())
						.append(", rows: [");
			} else {
				stringBuilder
						.append("{ total: 2, page: 1, records: 11, rows: [");
			}
			Iterator iter = objs.iterator();
			while (iter.hasNext()) {
				Object obj = iter.next();
				Map map = (Map) obj;
				stringBuilder.append("{id:'");
				if (null != map) {
					stringBuilder.append(PropertyUtils.getProperty(map, "id"));
					stringBuilder.append("',cell:[");
				}
				Iterator it = map.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();
					String key = "";
					String value = "";
					if (entry.getKey() != null)
						key = entry.getKey().toString();
					if (entry.getValue() != null) {
						value = entry.getValue().toString();
					}
					if ((!key.equals("serialVersionUID"))
							&& (!key.equals("ID"))) {
						if ((value != "") && (value != null))
							stringBuilder.append("'" + value + "'");
						if (it.hasNext()) {
							stringBuilder.append(",");
						}
					}
				}
				stringBuilder.append("]}");
			}
			stringBuilder.append(",");
			stringBuilder.append("]}");
		}
		return stringBuilder.toString();
	}

	public static String serializeJquery(List list) {
		JSONArray jsonArray = JSONArray.fromObject(list);
		String json = jsonArray.toString();
		return json;
	}

	public static String serialize1(List list) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		StringBuilder stringBuilder = new StringBuilder(1024);
		if ((null != list) && (list.size() != 0)) {
			Map lastMap = (Map) list.get(list.size() - 1);
			if (lastMap.get("count") != null) {
				stringBuilder.append("{ \"total\": ").append(
						lastMap.get("count"));
				stringBuilder.append(", \"rows\": [");
				list.remove(list.size() - 1);
			} else {
				stringBuilder
						.append("{ \"total\": \"2\", \"page\": \"1\", \"records\": \"11\", \"rows\": [");
			}
			for (int i = 0; i < list.size(); i++) {
				Map map = (Map) list.get(i);
				Iterator it = map.entrySet().iterator();
				stringBuilder.append("{");
				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();
					String key = "";
					String value = "";
					if (entry.getKey() != null)
						key = entry.getKey().toString();
					if (entry.getValue() != null) {
						value = entry.getValue().toString();
					}
					if ((!key.equals("serialVersionUID"))
							&& (!key.equals("ID"))) {
						stringBuilder.append("\"" + key + "\":");
						stringBuilder.append("\""
								+ HtmlToJson.toHTMLChar(value) + "\"");
						if (it.hasNext()) {
							stringBuilder.append(",");
						}
					}
				}
				stringBuilder.append("}");
				if (i < list.size() - 1) {
					stringBuilder.append(",");
				}
			}
		}
		stringBuilder.append("]}");
		return stringBuilder.toString();
	}

	public static String serializetoList(List list)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		StringBuilder stringBuilder = new StringBuilder(1024);
		for (int i = 0; i < list.size(); i++) {
			Map map = (Map) list.get(i);
			Iterator it = map.entrySet().iterator();
			stringBuilder.append("{");
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				String key = "";
				String value = "";
				if (entry.getKey() != null)
					key = entry.getKey().toString();
				if (entry.getValue() != null) {
					value = entry.getValue().toString();
				}
				if ((!key.equals("serialVersionUID")) && (!key.equals("ID"))) {
					if ((value != "") && (value != null))
						stringBuilder.append("\"" + key + "\":");
					stringBuilder.append("\"" + value + "\"");
					if (it.hasNext()) {
						stringBuilder.append(",");
					}
				}
			}
			stringBuilder.append("}");
			if (i < list.size() - 1) {
				stringBuilder.append(",");
			}
		}
		return stringBuilder.toString();
	}

	public static String serializetoListAjax(List list, String valueName)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		StringBuilder stringBuilder = new StringBuilder(1024);
		for (int i = 0; i < list.size(); i++) {
			Map map = (Map) list.get(i);
			Iterator it = map.entrySet().iterator();
			stringBuilder.append("{");
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				String key = "";
				String value = "";
				if (entry.getKey() != null)
					key = entry.getKey().toString();
				if (entry.getValue() != null) {
					value = entry.getValue().toString();
				}
				if ((!key.equals("serialVersionUID")) && (!key.equals("ID"))) {
					if ((value != "") && (value != null))
						stringBuilder.append("\"" + key + "\":");
					stringBuilder.append("\"" + value + "\"");
					if (key.equals(valueName) && value == null) {
						stringBuilder.append("\"checkbox\":");
						stringBuilder.append("\"true\"");
					}
					if (it.hasNext()) {
						stringBuilder.append(",");
					}
				}
			}
			stringBuilder.append("}");
			if (i < list.size() - 1) {
				stringBuilder.append(",");
			}
		}
		return stringBuilder.toString();
	}

	public static String serialize_tree(List list, String root_directory,
			String root_directory_value) throws Exception {
		StringBuffer sb = new StringBuffer();
		if (list.isEmpty()) {
			sb.append("{\"total\":");
			sb.append("\"0\"");
			sb.append(",\"rows\":[]}");
		} else {
			int size = list.size();
			sb.append("{\"total\":");
			sb.append("\"" + size + "\"");
			sb.append(",\"rows\":[");
			for (int i = 0; i < size; i++) {
				Map map = (Map) list.get(i);
				Iterator it = map.entrySet().iterator();
				sb.append("{");
				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();
					String key = "";
					String value = "";
					if (entry.getKey() != null)
						key = entry.getKey().toString();
					if (entry.getValue() != null) {
						value = entry.getValue().toString();
					}
					if (key.equals(root_directory)) {
						if (value.equals(root_directory_value)) {
							sb.append("\"state\":");
							sb.append("\"closed\"");
						} else {
							sb.append("\"_parentId\":");
							sb.append("\"" + value + "\"");
						}
						if (it.hasNext()) {
							sb.append(",");
						}
					}
					sb.append("\"" + key + "\":");
					sb.append("\"" + HtmlToJson.toHTMLChar(value) + "\"");

					if (it.hasNext()) {
						sb.append(",");
					}
				}
				if (i == size - 1) {
					sb.append("}");
				} else {
					sb.append("},");
				}
			}
			sb.append("]}");
		}
		return sb.toString();
	}
}
