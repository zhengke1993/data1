package com.yimai.Dao;

import java.util.List;

import com.yimai.entity.Product;


public interface ProductDao {
	public List<Product> getAll();
	public Product getById(int id);
	public void deleteById(int id);
	public void update(Product pro);
	public void add(Product pro);

}
