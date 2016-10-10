package com.yitianyigexiangfa.model;

import java.util.Date;

public class Programme {
	/**
	 * programme identity
	 */
	private int vol;
	/**
	 * programme title
	 */
	private String title;
	/**
	 * url
	 */
	private String url;
	/**
	 * spider execude time
	 */
	private Date sdate;
	public int getVol() {
		return vol;
	}
	public void setVol(int vol) {
		this.vol = vol;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
}
