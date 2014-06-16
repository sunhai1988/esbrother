package com.esbrother.system.hibernate;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CommonDAO extends HibernateDaoSupport
implements ICommonDAO{

	protected final transient Log log = LogFactory.getLog(getClass());
	  JdbcTemplate jdbcTemplate;

	  public JdbcTemplate getJdbcTemplate()
	  {
	    return this.jdbcTemplate;
	  }

	  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	  }

	  public Object saveOrUpdate(Object obj)
	    throws DataAccessException
	  {
	    getHibernateTemplate().saveOrUpdate(obj);
	    return obj;
	  }

	  public void saveOrUpdateAll(Collection entities) throws DataAccessException {
	    getHibernateTemplate().saveOrUpdateAll(entities);
	  }

	  public void delete(Object obj, LockMode lockMode) throws DataAccessException
	  {
	    getHibernateTemplate().delete(obj, lockMode);
	  }

	  public void update(String queryString, Object[] values) throws DataAccessException {
	    Session session = getSession();
	    Query query = session.createQuery(queryString);

	    for (int i = 0; i < values.length; i++) {
	      query.setParameter(i, values[i]);
	    }

	    Transaction tx = session.beginTransaction();
	    query.executeUpdate();
	    tx.commit();
	  }

	  public void update(String queryString, Object value) throws DataAccessException {
	    Session session = getSession();
	    Query query = session.createQuery(queryString);

	    query.setParameter(0, value);

	    Transaction tx = session.beginTransaction();
	    query.executeUpdate();
	    tx.commit();
	  }

	  public void update(String queryString) throws DataAccessException {
	    Session session = getSession();
	    Query query = session.createQuery(queryString);

	    Transaction tx = session.beginTransaction();
	    query.executeUpdate();
	    //tx.commit();
	  }

	  public int delete(String queryString) throws DataAccessException {
	    HibernateTemplate ht = getHibernateTemplate();
	    List objs = ht.find(queryString);
	    for (Iterator i$ = objs.iterator(); i$.hasNext(); ) { Object obj = i$.next();
	      ht.delete(obj);
	    }
	    return objs.size();
	  }

	  public int delete(String queryString, Object[] values) throws DataAccessException
	  {
	    HibernateTemplate ht = getHibernateTemplate();
	    List objs = ht.find(queryString, values);
	    for (Iterator i$ = objs.iterator(); i$.hasNext(); ) { Object obj = i$.next();
	      ht.delete(obj);
	    }
	    return objs.size();
	  }

	  public int delete(String queryString, Object value) throws DataAccessException
	  {
	    HibernateTemplate ht = getHibernateTemplate();
	    List objs = ht.find(queryString, value);
	    for (Iterator i$ = objs.iterator(); i$.hasNext(); ) { Object obj = i$.next();
	      ht.delete(obj);
	    }
	    return objs.size();
	  }

	  public void delete(Class c, Serializable id) throws DataAccessException {
	    HibernateTemplate ht = getHibernateTemplate();
	    Object obj = ht.load(c, id);
	    ht.delete(obj);
	  }

	  public void delete(Class c, Serializable[] ids) throws DataAccessException {
	    HibernateTemplate ht = getHibernateTemplate();
	    for (Serializable id : ids) {
	      Object obj = ht.load(c, id);
	      ht.delete(obj);
	    }
	  }

	  public void delete(Object obj) throws DataAccessException {
	    getHibernateTemplate().delete(obj);
	  }

	  public void delete(Collection objs) throws DataAccessException {
	    getHibernateTemplate().deleteAll(objs);
	  }

	  public Object load(Class c, Serializable id, LockMode lockMode) throws DataAccessException
	  {
	    return getHibernateTemplate().load(c, id, lockMode);
	  }

	  public Object load(Class c, Serializable id) throws DataAccessException {
	    return getHibernateTemplate().load(c, id);
	  }

	

	  public Serializable create(Object obj) throws DataAccessException {
	    return getHibernateTemplate().save(obj);
	  }

	  public void update(Object obj) throws DataAccessException {
	    getHibernateTemplate().update(obj);
	  }

	  public QueryResult query(String baseHQL, BaseForm queryForm)
	    throws DataAccessException
	  {
		  
	    QueryResult result = new QueryResult();

	    HibernateTemplate ht = getHibernateTemplate();

	    baseHQL = prepareHQL(baseHQL, queryForm);
	    String[] paramNames = getParamNames(baseHQL, queryForm);
	    Object[] paramValues = getParamValues(paramNames, queryForm);
	    String hql = getQueryString(baseHQL, paramNames);

	    List cnt = ht.findByNamedParam(getQueryCountString(hql), paramNames, paramValues,-1,-1);
	    int count = Integer.parseInt(cnt.get(0).toString());
	    List list;
	    if (queryForm.getPage() != 0) {
	      PageInfo pageInfo = new PageInfo();
	      pageInfo.setPgsize(queryForm.getPage());
	      pageInfo.setCount(count);

	      int pgnum = validatePgnum(pageInfo.getPgcount(), queryForm.getRows());
	      pageInfo.setPgnum(pgnum);
	       list = ht.findByNamedParam(hql, paramNames, paramValues  , pgnum, queryForm.getPage());
	     
	      result.setPageInfo(pageInfo);
	    } else {
	      list = ht.findByNamedParam(hql, paramNames, paramValues,-1,-1);
	    }

	    result.setData(list);
	    return result;
	    
//		  return null;
	  }

	  public Collection query(String hql, Serializable param) throws DataAccessException {
	    return getHibernateTemplate().find(hql, param);
	  }

	  public Collection query(String hql, Serializable[] params) throws DataAccessException {
	    return getHibernateTemplate().find(hql, params);
	  }

	  public Collection query(String hql) throws DataAccessException {
	    return getHibernateTemplate().find(hql);
	  }

	  private String prepareHQL(String baseHQL, BaseForm queryForm)
	  {
	    StringBuilder result = new StringBuilder(512);

	    String[] clips = baseHQL.split(" ");
	    ArrayList list = new ArrayList();
	    String item = null;

	    for (int i = 0; i < clips.length; i++) {
	      item = clips[i];
	      if ((item.startsWith(":")) && (clips[(i - 1)].equals("in"))) {
	        item = item.substring(1);
	        try {
	          if (null != PropertyUtils.getProperty(queryForm, item))
	            list.add(item.trim());
	        }
	        catch (IllegalAccessException e) {
	          e.printStackTrace();
	        } catch (InvocationTargetException e) {
	          e.printStackTrace();
	        } catch (NoSuchMethodException e) {
	          e.printStackTrace();
	        }
	      }
	    }

	    for (String clip : clips) {
	      if (!list.contains(clip.substring(1))) {
	        result.append(clip).append(' ');
	      } else {
	        String str = "";
	        try {
	          str = (String)PropertyUtils.getProperty(queryForm, item);
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
	        result.append("(").append(str).append(")");
	      }
	    }
	    return result.toString();
	  }

	  private int validatePgnum(int pgcount, int pgnum) {
	    if (pgnum < 1) {
	      pgnum = 1;
	    }
	    if (pgnum > pgcount) {
	      pgnum = pgcount;
	    }
	    return pgnum;
	  }

	  private String getQueryCountString(String hql) {
	    int index = hql.toLowerCase().indexOf("from");
	    String result = hql.substring(index);
	    result = "select count(*) " + result;

	    return result;
	  }

	  private String getQueryString(String baseHQL, String[] paramNames) {
	    StringBuilder result = new StringBuilder(512);
	    String[] order = baseHQL.split(" order ");
	    String[] temp = order[0].split(" where ");
	    result.append(temp[0]);
	    if (temp.length > 1) {
	      String[] temp1 = temp[1].split(" and ");

	      boolean where = false;

	      for (String aTemp1 : temp1) {
	        String[] tt = aTemp1.split(":");
	        if ((tt.length != 2) || ((tt.length == 2) && (exist(tt[1].trim(), paramNames)))) {
	          if (!where) {
	            result.append(" where ");
	            where = true;
	          } else {
	            result.append(" and ");
	          }
	          result.append(aTemp1);
	        }
	      }
	    }
	    if (order.length != 1) {
	      result.append(" order ").append(order[1]);
	    }
	    return result.toString();
	  }

	  private boolean exist(String paramName, String[] paramNames) {
	    boolean exist = false;
	    for (String item : paramNames) {
	      if (item.equals(paramName)) {
	        exist = true;
	        break;
	      }
	    }
	    return exist;
	  }

	  private Object[] getParamValues(String[] paramNames, Object queryForm)
	  {
	    Object[] result = new Object[paramNames.length];

	    for (int i = 0; i < paramNames.length; i++) {
	      String paramName = paramNames[i];
	      try {
	        result[i] = PropertyUtils.getProperty(queryForm, paramName);
	      } catch (IllegalAccessException e) {
	        e.printStackTrace();
	      } catch (InvocationTargetException e) {
	        e.printStackTrace();
	      } catch (NoSuchMethodException e) {
	        e.printStackTrace();
	      }
	    }
	    return result;
	  }

	  private  String[] getParamNames(String baseHQL, Object queryForm)
	  {
	    String[] clip = baseHQL.split(" ");
	    ArrayList list = new ArrayList();

	    for (int i = 0; i < clip.length; i++) {
	      String item = clip[i];
	      if ((item.startsWith(":")) && (!clip[(i - 1)].equals("in"))) {
	        item = item.substring(1);
	        try {
	          if (null != PropertyUtils.getProperty(queryForm, item))
	            list.add(item.trim());
	        }
	        catch (IllegalAccessException e) {
	          e.printStackTrace();
	        } catch (InvocationTargetException e) {
	          e.printStackTrace();
	        } catch (NoSuchMethodException e) {
	          e.printStackTrace();
	        }
	      }
	    }
	    String[] result = new String[list.size()];
	    for (int i = 0; i < list.size(); i++) {
	      result[i] = ((String)list.get(i));
	    }
	    return result;
	  }

	  public int queryForInt(String sql)
	  {
	    return this.jdbcTemplate.queryForInt(sql);
	  }

	  public int queryForInt(String sql, Object[] params) {
	    return this.jdbcTemplate.queryForInt(sql, params);
	  }

	  public List queryForList(String sql) {
	    return this.jdbcTemplate.queryForList(sql);
	  }

	  public List queryForList(String s, Object[] params) {
	    return this.jdbcTemplate.queryForList(s, params);
	  }

	  public void execute(String sql) {
	    this.jdbcTemplate.execute(sql);
	  }

	  public int execute(String sql, Object[] params) {
	    return this.jdbcTemplate.update(sql, params);
	  }

	  public List queryForList(String sql, BaseForm queryForm)
	  {
	    return queryForList(sql, null, queryForm);
	  }

	  public List queryForList(String sql, Object[] params, BaseForm queryForm)
	  {
		   List listjson = new ArrayList();
	    List dataList = new ArrayList();
	    if (queryForm.getRows() != 0)
	    {
	      List list;
	    
	      if (params == null)
	        list = this.jdbcTemplate.queryForList(sql);
	      else {
	        list = this.jdbcTemplate.queryForList(sql, params);
	      }
	      int dataCount = list.size();
	      int pcount = list.size() / queryForm.getRows();
	      int mod = list.size() % queryForm.getRows();

	      int pageCount = 1;
	      if (pcount >= 1) {
	        pageCount = list.size() / queryForm.getRows();
	        if (mod > 0) {
	          pageCount += 1;
	        }

	      }

	      int Pgnum = 1;
	      if (queryForm.getPage() <= pageCount) {
	        Pgnum = queryForm.getPage();
	      }
	      int s = 0; for (int i = (Pgnum - 1) * queryForm.getRows(); i < Pgnum * queryForm.getRows(); s++) {
	        try {
	          dataList.add((Map)list.get(i));
	        }
	        catch (Exception e)
	        {
	        }
	        i++;
	      }
	   
	      Map map = new HashMap();
	      
	      map.put("pgnum", Integer.valueOf(Pgnum));
	      map.put("pgsize", Integer.valueOf(queryForm.getRows()));
	      map.put("count", Integer.valueOf(dataCount));
	      map.put("pgcount", Integer.valueOf(pageCount));
//	      map.put("rows", dataList);
	      dataList.add(map);
//	      listjson.add(map);
	    }
	    else if (params == null) {
	      dataList = this.jdbcTemplate.queryForList(sql);
	    } else {
	      dataList = this.jdbcTemplate.queryForList(sql, params);
	    }

	    return dataList;
	  }


	public List loadAll(Class paramClass) throws DataAccessException {
		
		return this.getHibernateTemplate().loadAll(paramClass);
	}

	public void save(Object paramObject) {
		this.getHibernateTemplate().save(paramObject);
		
	}

//	public static void main(String srgs[]){
////		getParamNames("from user","");
//		System.out.println("dsds");
//	}
}
