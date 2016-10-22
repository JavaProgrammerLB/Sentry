package com.yitianyigexiangfa.model;

import java.util.Date;

public class User2pro {
	private int id;
	private int userid;
	private int proid;
	/**
	 * email send time
	 */
	private Date emtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public Date getEmtime() {
		return emtime;
	}
	public void setEmtime(Date emtime) {
		this.emtime = emtime;
	}
	
}
