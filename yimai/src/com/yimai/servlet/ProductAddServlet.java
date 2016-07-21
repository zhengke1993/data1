package com.yimai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.Dao.ProductDao;
import com.yimai.Dao.impl.ProductDaoImpl;
import com.yimai.entity.Product;

public class ProductAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String productName = request.getParameter("productName");
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		String productDesc = request.getParameter("productDesc");
		String photo = request.getParameter("photo");
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		int productStock = Integer.parseInt(request.getParameter("productStock"));
		Product pro = new Product();
		pro.setEp_name(productName);
		pro.setEp_description(productDesc);
		pro.setEp_file_name(photo);
		pro.setEp_price(productPrice);
		pro.setEp_stock(productStock);
		pro.setEpc_id(parentId);
		ProductDao dao = new ProductDaoImpl();
		dao.add(pro);
	}

}
