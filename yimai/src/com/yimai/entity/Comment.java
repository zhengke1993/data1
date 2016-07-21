package com.yimai.entity;

import java.sql.Date;

public class Comment {
	private int ec_id;
	private String ec_reply;
	private String ec_content;
	private Date ec_create_time;
	private Date ec_reply_time;
	private String ec_nick_name;
	public int getEc_id() {
		return ec_id;
	}
	public void setEc_id(int ecId) {
		ec_id = ecId;
	}
	public String getEc_reply() {
		return ec_reply;
	}
	public void setEc_reply(String ecReply) {
		ec_reply = ecReply;
	}
	public String getEc_content() {
		return ec_content;
	}
	public void setEc_content(String ecContent) {
		ec_content = ecContent;
	}
	public Date getEc_create_time() {
		return ec_create_time;
	}
	public void setEc_create_time(Date date) {
		ec_create_time = date;
	}
	public Date getEc_reply_time() {
		return ec_reply_time;
	}
	public void setEc_reply_time(Date date) {
		ec_reply_time = date;
	}
	public String getEc_nick_name() {
		return ec_nick_name;
	}
	public void setEc_nick_name(String ecNickName) {
		ec_nick_name = ecNickName;
	}

	public Comment(int ecid, String ecreply, Date eccontent, String eccreatetime, Date ecreplytime, String ecnickname){
		super();
		ec_id = ecid;
		ec_content = ecreply;
		ec_create_time = eccontent;
		ec_reply = eccreatetime;
		ec_reply_time = ecreplytime;
		ec_nick_name = ecnickname;
	}
	public Comment() {
		super();
	}
	

}
