package com.yimai.entity;

public class Category {
	private int epc_id;
	private String epc_name;
	private String epc_parent_id;
	public int getEpc_id() {
		return epc_id;
	}
	public void setEpc_id(int epcId) {
		epc_id = epcId;
	}
	public String getEpc_name() {
		return epc_name;
	}
	public void setEpc_name(String epcName) {
		epc_name = epcName;
	}
	public String getEpc_parent_id() {
		return epc_parent_id;
	}
	public void setEpc_parent_id(String epcParentId) {
		epc_parent_id = epcParentId;
	}
	public Category(int epcid, String epcname, String epcparentid){
		super();
		epc_id = epcid;
		epc_name = epcname;
		epc_parent_id = epcparentid;
	}

}
