package com.yimai.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yimai.Dao.Base;
import com.yimai.Dao.ProductDao;
import com.yimai.entity.Product;

public class ProductDaoImpl extends Base implements ProductDao{
	//物品列表
	public List<Product> getAll(){
		Connection conn = super.getConn();
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from easybuy_product";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product pro = new Product();
				pro.setEp_id(rs.getInt(1));
				pro.setEp_name(rs.getString(2));
				pro.setEp_description(rs.getString(3));
				pro.setEp_price(rs.getFloat(4));
				pro.setEp_stock(rs.getInt(5));
				pro.setEpc_id(rs.getInt(6));
				pro.setEpc_child_id(rs.getInt(7));
				pro.setEp_file_name(rs.getString(8));
				list.add(pro);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(rs, ps, conn);
		}
		return list;		
	}
	//查看物品
	public Product getById(int id){
		Connection conn = super.getConn();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Product pro = new Product();
		String sql = "select * from easybuy_product where ep_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				pro.setEp_id(rs.getInt(1));
				pro.setEp_name(rs.getString(2));
				pro.setEp_description(rs.getString(3));
				pro.setEp_price(rs.getFloat(4));
				pro.setEp_stock(rs.getInt(5));
				pro.setEpc_id(rs.getInt(6));
				pro.setEpc_child_id(rs.getInt(7));
				pro.setEp_file_name(rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(rs, ps, conn);
		}
		return pro;
		
	}
	//删除物品
	public void deleteById(int id){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		String sql = "delete from easybuy_product where ep_id=?";
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
	//修改物品
	public void update(Product pro){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		String sql = "update easybuy_product set ep_name=?,ep_description=?,ep_price=?,ep_stock=? where ep_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pro.getEp_name());
			ps.setString(2, pro.getEp_description());
			ps.setFloat(3, pro.getEp_price());
			ps.setInt(4, pro.getEp_stock());
			ps.setInt(5, pro.getEp_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(null, ps, conn);
		}
	}
	//添加物品
	public void add(Product pro){
		Connection conn = super.getConn();
		PreparedStatement ps = null;
		String sql = "insert into easybuy_product values(epid_sq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pro.getEp_name());
			ps.setString(2, pro.getEp_description());
			ps.setFloat(3, pro.getEp_price());
			ps.setInt(4, pro.getEp_stock());
			ps.setInt(5, pro.getEpc_id());
			ps.setInt(6, pro.getEpc_child_id());
			ps.setString(7, pro.getEp_file_name());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(null, ps, conn);
		}
	}
}
