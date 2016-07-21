package com.yimai.Dao;

import java.util.List;

import com.yimai.entity.Order;



public interface OrderDao {
	public List<Order> getAll();
	public Order getById(int id);
	public void deleteById(int id);
	public void add(Order order);

}
