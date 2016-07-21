package com.yimai.entity;

public class OrderDetail {
	private int eod_id;
	private int eo_id;
	private int ep_id;
	private int eod_quantity;
	private float eod_cost;
	public int getEod_id() {
		return eod_id;
	}
	public void setEod_id(int eodId) {
		eod_id = eodId;
	}
	public int getEo_id() {
		return eo_id;
	}
	public void setEo_id(int eoId) {
		eo_id = eoId;
	}
	public int getEp_id() {
		return ep_id;
	}
	public void setEp_id(int epId) {
		ep_id = epId;
	}
	public int getEod_quantity() {
		return eod_quantity;
	}
	public void setEod_quantity(int eodQuantity) {
		eod_quantity = eodQuantity;
	}
	public float getEod_cost() {
		return eod_cost;
	}
	public void setEod_cost(float eodCost) {
		eod_cost = eodCost;
	}
	public OrderDetail(int eodid, int eoid, int epid, int eodquantity, float eodcost){
		super();
		eod_id = eodid;
		eo_id = eoid;
		ep_id = epid;
		eod_quantity = eodquantity;
		eod_cost = eodcost;
	}

}
