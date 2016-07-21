package com.yimai.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yimai.Dao.Base;
import com.yimai.Dao.CommentDao;
import com.yimai.entity.Comment;
//获取留言列表
public class CommentDaoImpl extends Base implements CommentDao{
	public List<Comment> getAll(){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Comment> list = new ArrayList<Comment>();
		String sql = "select * from easybuy_comment";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Comment com = new Comment();
				com.setEc_id(rs.getInt(1));
				com.setEc_reply(rs.getString(2));
				com.setEc_content(rs.getString(3));
				com.setEc_create_time(rs.getDate(4));
				com.setEc_reply_time(rs.getDate(5));
				com.setEc_nick_name(rs.getString(6));
				list.add(com);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(rs, ps, conn);
		}
		return list;
		
	}
	//删除留言
	public void deleteById(int id){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		String sql = "delete from easybuy_comment where ec_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(null, ps, conn);
		}
	}
	//修改回复
	public void reply(int id, String reply){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		int r = 0;
		System.out.println("id=" + id);
		String sql = "update easybuy_comment set ec_reply=?,ec_reply_time=sysdate where ec_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, reply);
			ps.setInt(2, id);
			r = ps.executeUpdate();
			System.out.println(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(null, ps, conn);
		}
	}
	//查找留言
	public Comment getById(int id){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Comment com = new Comment();
		String sql = "select * from easybuy_comment where ec_id= ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				com.setEc_id(rs.getInt(1));
				com.setEc_content(rs.getString(2));
				com.setEc_create_time(rs.getDate(3));
				com.setEc_reply(rs.getString(4));
				com.setEc_reply_time(rs.getDate(5));
				com.setEc_nick_name(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(rs, ps, conn);
		}
		return com;
		
	}
	//增加留言
	public void addComment(Comment com){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		int a = 0;
		String sql = "insert  into  easybuy_comment values(ecid_sq.nextval,?,sysdate,null,null,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, com.getEc_content());
			ps.setString(2, com.getEc_nick_name());
			a = ps.executeUpdate();
			System.out.println(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(null, ps, conn);
		}
	}
}
