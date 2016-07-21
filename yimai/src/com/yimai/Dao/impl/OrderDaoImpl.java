package com.yimai.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yimai.Dao.Base;
import com.yimai.Dao.OrderDao;
import com.yimai.entity.Order;

public class OrderDaoImpl extends Base implements OrderDao{
	//获取订单列表
	public List<Order> getAll(){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Order> list = new ArrayList<Order>();
		String sql = "select  *  from   easybuy_order";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order or = new Order();
				or.setEo_id(rs.getInt(1));
				or.setEo_user_id(rs.getInt(2));
				or.setEo_user_name(rs.getString(3));
				or.setEo_user_address(rs.getString(4));
				or.setEo_create_time(rs.getDate(5));
				or.setEo_cost(rs.getInt(6));
				or.setEo_status(rs.getInt(7));
				or.setEo_type(rs.getInt(8));
				list.add(or);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(rs, ps, conn);
		}
		return list;
		
	}
	//查看订单
	public Order getById(int id){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order order = new Order();
		String sql = "select  *  from  easybuy_order  where  eo_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				order.setEo_id(rs.getInt(1));
				order.setEo_user_id(rs.getInt(2));
				order.setEo_user_name(rs.getString(3));
				order.setEo_user_address(rs.getString(4));
				order.setEo_create_time(rs.getDate(5));
				order.setEo_cost(rs.getInt(6));
				order.setEo_status(rs.getInt(7));
				order.setEo_type(rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(rs, ps, conn);
		}
		return order;
		
	}
	//删除订单
	public void deleteById(int id){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		String sql = "delete from easybuy_order where eo_id=?";
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
	//添加订单
	public void add(Order order){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		String sql = "insert into easybuy_order values (eoid_sq.nextval, ?, ?, ?, sysdate, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, order.getEo_user_id());
			ps.setString(2, order.getEo_user_name());
			ps.setString(3, order.getEo_user_address());
			ps.setFloat(4, order.getEo_cost());
			ps.setInt(5, order.getEo_status());
			ps.setInt(6, order.getEo_type());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(null, ps, conn);
		}
	}
}
