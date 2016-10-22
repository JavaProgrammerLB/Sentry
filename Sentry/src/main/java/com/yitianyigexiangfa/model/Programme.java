package com.yitianyigexiangfa.model;

import java.util.Date;

public class Programme {
	/**
	 * identity
	 */
	private int id;
	/**
	 * seed url
	 */
	private String seed;
	/**
	 * name
	 */
	private String name;
	/**
	 * vol
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
	 * from which server,such as youku、iqiyi
	 */
	private int server;
	/**
	 * spider execude time
	 */
	private Date sdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeed() {
		return seed;
	}

	public void setSeed(String seed) {
		this.seed = seed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public int getServer() {
		return server;
	}

	public void setServer(int server) {
		this.server = server;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

}