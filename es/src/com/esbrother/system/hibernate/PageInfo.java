package com.esbrother.system.hibernate;

import java.io.Serializable;

public class PageInfo implements Serializable {
	private int count;
	  private int pgcount;
	  private int pgnum;
	  private int pgsize;

	  public Integer getPgnum()
	  {
	    return Integer.valueOf(this.pgnum);
	  }

	  public void setPgnum(int pgnum) {
	    this.pgnum = pgnum;
	  }

	  public Integer getCount() {
	    return Integer.valueOf(this.count);
	  }

	  public void setCount(int count) {
	    this.count = count;
	    if (this.pgsize > 0) {
	      int pgcount = count / this.pgsize;
	      if (count % this.pgsize != 0) {
	        pgcount++;
	      }
	      this.pgcount = pgcount;
	    } else {
	      this.pgcount = 1;
	    }
	  }

	  public int getPgcount() {
	    return this.pgcount;
	  }

	  public void setPgcount(int pgcount) {
	    this.pgcount = pgcount;
	  }

	  public int getPgsize() {
	    return this.pgsize;
	  }

	  public void setPgsize(int pgsize) {
	    this.pgsize = pgsize;
	  }
}
