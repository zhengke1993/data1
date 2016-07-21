package com.yimai.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yimai.Dao.Base;
import com.yimai.Dao.NewsDao;
import com.yimai.entity.News;

public class NewsDaoImpl extends Base implements NewsDao{
	//获取全部新闻列表
	public List<News> getAll(){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<News> list = new ArrayList<News>();
		String sql = "select * from easybuy_news";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				News news = new News();
				news.setEn_id(rs.getInt(1));
				news.setEn_title(rs.getString(2));
				news.setEn_content(rs.getString(3));
				news.setEn_create_time(rs.getDate(4));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(rs, ps, conn);
		}
		
		return list;
		
	}
	//查看新闻
	public News getById(int id){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		News news = new News();
		String sql="select * from easybuy_news where en_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				news.setEn_id(rs.getInt(1));
				news.setEn_title(rs.getString(2));
				news.setEn_content(rs.getString(3));
				news.setEn_create_time(rs.getDate(4));
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(rs, ps, conn);
		}
		
		return news;
		
		
		
	}
	//删除新闻
	public void deleteById(int id){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		String sql="delete from easybuy_news where en_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(null, ps, conn);
		}
	}
	//修改新闻
	public void update(News news){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		String sql = "update easybuy_news set  en_title=?,en_content=?,en_create_time=sysdate where en_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, news.getEn_title());
			ps.setString(2, news.getEn_content());
			ps.setInt(3, news.getEn_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(null, ps, conn);
		}

	}
	//添加新闻
	public void addNews(String title, String content){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		String sql="insert  into  easybuy_news values(enid_sq.nextval,?,?,sysdate)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(null, ps, conn);
		}
	}

}
