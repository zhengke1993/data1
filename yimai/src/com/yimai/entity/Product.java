package com.yimai.entity;

public class Product {
	private int ep_id;
	private String ep_name;
	private String ep_description;
	private float ep_price;
	private int ep_stock;
	private int epc_id;
	private int epc_child_id;
	private String ep_file_name;
	public int getEp_id() {
		return ep_id;
	}
	public void setEp_id(int epId) {
		ep_id = epId;
	}
	public String getEp_name() {
		return ep_name;
	}
	public void setEp_name(String epName) {
		ep_name = epName;
	}
	public String getEp_description() {
		return ep_description;
	}
	public void setEp_description(String epDescription) {
		ep_description = epDescription;
	}
	public float getEp_price() {
		return ep_price;
	}
	public void setEp_price(float epPrice) {
		ep_price = epPrice;
	}
	public int getEp_stock() {
		return ep_stock;
	}
	public void setEp_stock(int epStock) {
		ep_stock = epStock;
	}
	public int getEpc_id() {
		return epc_id;
	}
	public void setEpc_id(int epcId) {
		epc_id = epcId;
	}
	public int getEpc_child_id() {
		return epc_child_id;
	}
	public void setEpc_child_id(int epcChildId) {
		epc_child_id = epcChildId;
	}
	public String getEp_file_name() {
		return ep_file_name;
	}
	public void setEp_file_name(String epFileName) {
		ep_file_name = epFileName;
	}
	public Product(int epid, String epname, String epdescription, float epprice, int epstock, int epcid, int epcchildid, String epfilename){
		super();
		ep_id = epid;
		ep_name = epname;
		ep_description = epdescription;
		ep_price = epprice;
		ep_stock = epstock;
		epc_id = epcid;
		epc_child_id = epcchildid;
		ep_file_name = epfilename;
	}
	public Product() {
		super();
	}

}
