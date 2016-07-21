package com.yimai.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yimai.Dao.Base;
import com.yimai.Dao.UserDao;
import com.yimai.entity.User;

public class UserDaoImpl extends Base implements UserDao {
	public List<User> getAll(){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		String sql = "select * from easybuy_user";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setEu_user_id(rs.getString(1));
				user.setEu_user_name(rs.getString(2));
				user.setEu_password(rs.getString(3));
				user.setEu_sex(rs.getString(4));
				user.setEu_birthday(rs.getString(5));
				user.setEu_identity_code(rs.getString(6));
				user.setEu_email(rs.getString(7));
				user.setEu_mobile(rs.getString(8));
				user.setEu_address(rs.getString(9));
				user.setEu_status(rs.getInt(10));
				list.add(user);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(rs, ps, conn);
		}

		return list;
		
	}
	public void deleteById(String uid){
		Connection conn = super.getConn();
		PreparedStatement ps = null;

		try {
			String sql = "delete from easybuy_user where eu_user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(null, ps, conn);
		}
	}
	public User getById(String uid){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = new User();

		try {
			String sql = "select * from easybuy_user where eu_user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setEu_user_id(rs.getString(1));
				user.setEu_user_name(rs.getString(2));
				user.setEu_password(rs.getString(3));
				user.setEu_sex(rs.getString(4));
				user.setEu_birthday(rs.getString(5));
				user.setEu_identity_code(rs.getString(6));
				user.setEu_email(rs.getString(7));
				user.setEu_mobile(rs.getString(8));
				user.setEu_address(rs.getString(9));
				user.setEu_status(rs.getInt(10));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(rs, ps, conn);
		}

		return user;
		
	}
	public void update(User user){
		Connection conn = super.getConn();
		PreparedStatement ps = null;

		String sql = "update easybuy_user set eu_user_name =?, eu_password =?,eu_sex=?,eu_mobile=?,eu_address=?  where eu_user_id=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEu_user_name());
			ps.setString(2, user.getEu_password());
			ps.setString(3, user.getEu_sex());
			ps.setString(4, user.getEu_mobile());
			ps.setString(5, user.getEu_address());
			ps.setString(6, user.getEu_user_id());
			

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(null, ps, conn);
		}
	}
	public boolean login(String user, String pwd){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean bool = false;

		try {
			String sql = "select * from easybuy_user where eu_user_name=? and eu_password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if (rs.next()) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(rs, ps, conn);
		}

		return bool;
		
	}
	public int addUser(User user){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i = 0;
		String sql = "insert into easybuy_user (eu_user_id,eu_password,eu_status)values(?,?,1)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEu_user_id());
			ps.setString(2, user.getEu_password());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(rs, ps, conn);
		}
		return i;
	}
	public int addManageUser(User ManageUser){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i = 0;
		String sql = "insert into easybuy_user (eu_user_id,eu_user_name ,eu_password,eu_sex ,eu_mobile ,eu_address ,eu_status)values(?,?,?,?,?,?,2)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ManageUser.getEu_user_id());
			ps.setString(2, ManageUser.getEu_user_name());
			ps.setString(3, ManageUser.getEu_password());
			ps.setString(4, ManageUser.getEu_sex());
			ps.setString(5, ManageUser.getEu_mobile());
			ps.setString(6, ManageUser.getEu_address());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(rs, ps, conn);
		}
		return i;
	}
	public boolean check(String user){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean bool = false;

		try {
			String sql = "select * from easybuy_user where eu_user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			rs = ps.executeQuery();
			if (rs.next()) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(rs, ps, conn);
		}

		return bool;
		
	}
}
