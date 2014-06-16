package com.esbrother.system.spring;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.esbrother.system.hibernate.BaseForm;
import com.esbrother.system.hibernate.ICommonDAO;
import com.esbrother.system.hibernate.QueryResult;

public class BaseBO {
	protected ICommonDAO commonDAO;
	protected Log log = LogFactory.getLog(getClass());

	public void setCommonDAO(ICommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	protected String getInExpFromArray(String[] candidateid) {
		StringBuilder clearHQL = new StringBuilder("(");
		for (String aCandidateid : candidateid) {
			clearHQL.append("'").append(aCandidateid).append("',");
		}

		clearHQL.deleteCharAt(clearHQL.length() - 1);
		clearHQL.append(")");
		return clearHQL.toString();
	}

	protected String getInExpFromArray(Collection objs) {
		StringBuilder clearHQL = new StringBuilder("(");
		try {
			for (Iterator i$ = objs.iterator(); i$.hasNext();) {
				Object obj = i$.next();
				String id;

				if ((obj instanceof String))
					id = (String) obj;
				else {
					id = (String) PropertyUtils.getProperty(obj, "id");
				}
				clearHQL.append("'").append(id).append("',");
			}
		} catch (Exception e) {
			Iterator i$;
			e.printStackTrace();
		}
		clearHQL.deleteCharAt(clearHQL.length() - 1);
		clearHQL.append(")");
		return clearHQL.toString();
	}

	protected QueryResult loop(Class clazz, BaseForm form) throws Exception {
		QueryResult result = this.commonDAO.query("from " + clazz.getName()
				+ " as obj", form);
		return result;
	}
}