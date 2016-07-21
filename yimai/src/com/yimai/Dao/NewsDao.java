package com.yimai.Dao;

import java.util.List;

import com.yimai.entity.News;



public interface NewsDao {
	public List<News> getAll();
	public News getById(int id);
	public void deleteById(int id);
	public void update(News news);
	public void addNews(String title, String content);

}
