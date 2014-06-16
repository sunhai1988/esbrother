package com.esbrother.system.hibernate;

public class BaseQueryForm {
	int pgnum;
	int pgsize;

	public int getPgnum() {
		return this.pgnum;
	}

	public void setPgnum(int pgnum) {
		this.pgnum = pgnum;
	}

	public int getPgsize() {
		return this.pgsize;
	}

	public void setPgsize(int pgsize) {
		this.pgsize = pgsize;
	}
}
