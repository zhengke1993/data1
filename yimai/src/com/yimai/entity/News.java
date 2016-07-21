package com.yimai.entity;

import java.util.Date;

public class News {
	private int en_id;
	private String en_title;
	private String en_content;
	private Date en_create_time;
	public int getEn_id() {
		return en_id;
	}
	public void setEn_id(int enId) {
		en_id = enId;
	}
	public String getEn_title() {
		return en_title;
	}
	public void setEn_title(String enTitle) {
		en_title = enTitle;
	}
	public String getEn_content() {
		return en_content;
	}
	public void setEn_content(String enContent) {
		en_content = enContent;
	}
	public Date getEn_create_time() {
		return en_create_time;
	}
	public void setEn_create_time(Date enCreateTime) {
		en_create_time = enCreateTime;
	}

	public News(int enid, String entitle, String encontent, Date encreatetime){
		super();
		en_id = enid;
		en_title = entitle;
		en_content = encontent;
		en_create_time = encreatetime;
	}
	public News() {
		super();
	}

}
