package com.esbrother.system.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.LockMode;
import org.springframework.dao.DataAccessException;

public interface ICommonDAO {
	 public abstract Object saveOrUpdate(Object paramObject)
	    throws DataAccessException;

	  public abstract void saveOrUpdateAll(Collection paramCollection)
	    throws DataAccessException;

	  public abstract void update(String paramString, Object[] paramArrayOfObject)
	    throws DataAccessException;

	  public abstract void update(String paramString, Object paramObject)
	    throws DataAccessException;

	  public abstract void update(String paramString)
	    throws DataAccessException;

	  public abstract void delete(Object paramObject, LockMode paramLockMode)
	    throws DataAccessException;

	  public abstract int delete(String paramString)
	    throws DataAccessException;

	  public abstract int delete(String paramString, Object[] paramArrayOfObject)
	    throws DataAccessException;

	  public abstract int delete(String paramString, Object paramObject)
	    throws DataAccessException;

	  public abstract Object load(Class paramClass, Serializable paramSerializable, LockMode paramLockMode)
	    throws DataAccessException;

	  public abstract List loadAll(Class paramClass)
	    throws DataAccessException;

	  public abstract Object load(Class paramClass, Serializable paramSerializable)
	    throws DataAccessException;

	  public abstract Serializable create(Object paramObject)
	    throws DataAccessException;

	  public abstract void delete(Class paramClass, Serializable paramSerializable)
	    throws DataAccessException;

	  public abstract void delete(Class paramClass, Serializable[] paramArrayOfSerializable)
	    throws DataAccessException;

	  public abstract void delete(Object paramObject)
	    throws DataAccessException;

	  public abstract void delete(Collection paramCollection)
	    throws DataAccessException;

	  public abstract void update(Object paramObject)
	    throws DataAccessException;

	  public abstract QueryResult query(String paramString, BaseForm paramBaseQueryForm)
	    throws DataAccessException;

	  public abstract Collection query(String paramString, Serializable paramSerializable)
	    throws DataAccessException;

	  public abstract Collection query(String paramString, Serializable[] paramArrayOfSerializable)
	    throws DataAccessException;

	  public abstract Collection query(String paramString)
	    throws DataAccessException;

	  public abstract int queryForInt(String paramString);

	  public abstract int queryForInt(String paramString, Object[] paramArrayOfObject);

	  public abstract List queryForList(String paramString);

	  public abstract List queryForList(String paramString, Object[] paramArrayOfObject);

	  public abstract void execute(String paramString);

	  public abstract int execute(String paramString, Object[] paramArrayOfObject);

	  public abstract List queryForList(String paramString, BaseForm paramBaseQueryForm);

	public abstract List queryForList(String paramString, Object[] paramArrayOfObject, BaseForm paramBaseQueryForm);
	
	public abstract void save(Object paramObject);
}
