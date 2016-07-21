package com.yimai.Dao;

import java.util.List;

import com.yimai.entity.User;

public interface UserDao {
	public List<User> getAll();	
	public void deleteById(String uid);
	public User getById(String uid);
	public void update(User user);
	public boolean login(String user, String pwd);
	public int addUser(User user);

}
