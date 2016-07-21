package com.yimai.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.entity.ProductItem;

public class ShoppingUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
	}


	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("gbk");
		int id = Integer.parseInt(request.getParameter("id"));
		int num = Integer.parseInt(request.getParameter("num"));
		List<ProductItem> list = new ArrayList<ProductItem>();
		list = (List) request.getSession().getAttribute("crt");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPto().getEp_id() == id) {
				list.get(i).setNum(num);
			}
		}
		response.sendRedirect("shopping.jsp");

	}
}
