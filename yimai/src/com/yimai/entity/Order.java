package com.yimai.entity;

import java.sql.Date;

public class Order {
	private int eo_id;
	private int eo_user_id;
	private String eo_user_name;
	private String eo_user_address;
	private Date eo_create_time;
	private float eo_cost;
	private int eo_status;
	private int eo_type;
	public int getEo_id() {
		return eo_id;
	}
	public void setEo_id(int eoId) {
		eo_id = eoId;
	}
	public int getEo_user_id() {
		return eo_user_id;
	}
	public void setEo_user_id(int eoUserId) {
		eo_user_id = eoUserId;
	}
	public String getEo_user_name() {
		return eo_user_name;
	}
	public void setEo_user_name(String eoUserName) {
		eo_user_name = eoUserName;
	}
	public String getEo_user_address() {
		return eo_user_address;
	}
	public void setEo_user_address(String eoUserAddress) {
		eo_user_address = eoUserAddress;
	}
	public Date getEo_create_time() {
		return eo_create_time;
	}
	public void setEo_create_time(Date date) {
		eo_create_time = date;
	}
	public float getEo_cost() {
		return eo_cost;
	}
	public void setEo_cost(float eoCost) {
		eo_cost = eoCost;
	}
	public int getEo_status() {
		return eo_status;
	}
	public void setEo_status(int eoStatus) {
		eo_status = eoStatus;
	}
	public int getEo_type() {
		return eo_type;
	}
	public void setEo_type(int eoType) {
		eo_type = eoType;
	}
	public Order(int eoid, int eouserid, String eousername, String eouseraddress, Date eocreatetime, float eocost, int eostatus, int eotype){
		super();
		eo_id = eoid;
		eo_user_id = eouserid;
		eo_user_name = eousername;
		eo_user_address = eouseraddress;
		eo_create_time = eocreatetime;
		eo_cost = eocost;
		eo_status = eostatus;
		eo_type = eotype;
	}
	public Order() {
		super();
	}

}
