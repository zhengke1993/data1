package com.yimai.Dao;

import java.util.List;

import com.yimai.entity.Comment;



public interface CommentDao {
	public List<Comment> getAll();
	public void deleteById(int id);
	public void reply(int id, String reply);
	public Comment getById(int id);
	public void addComment(Comment com);

}
