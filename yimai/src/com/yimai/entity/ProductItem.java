package com.yimai.entity;


public class ProductItem {
	private Product pro;
	private int num;
	public Product getPto() {
		return pro;
	}
	public void setPto(Product pto) {
		this.pro = pto;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public ProductItem(Product pro, int num) {
		super();
		this.pro = pro;
		this.num = num;
	}
	public ProductItem() {
		super();
	}
}
