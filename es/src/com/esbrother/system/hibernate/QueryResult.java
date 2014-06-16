package com.esbrother.system.hibernate;

import java.util.Collection;



public class QueryResult {
	Collection data;
	  PageInfo pageInfo;

	  public Collection getData()
	  {
	    return this.data;
	  }

	  public void setData(Collection data)
	  {
	    this.data = data;
	  }

	  public PageInfo getPageInfo()
	  {
	    return this.pageInfo;
	  }

	  public void setPageInfo(PageInfo page)
	  {
	    this.pageInfo = page;
	  }
}
