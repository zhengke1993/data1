package com.yimai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.Dao.OrderDao;
import com.yimai.Dao.impl.OrderDaoImpl;
import com.yimai.entity.Order;

public class OrderAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		request.setCharacterEncoding("gbk");
		String username = request.getParameter("username");
		int userid = Integer.parseInt("userid");
		String addr = request.getParameter("addr");
		float cost = Integer.parseInt(request.getParameter("cost"));
		Order order = new Order();
		order.setEo_user_id(userid);
		order.setEo_user_name(username);
		order.setEo_user_address(addr);
		order.setEo_cost(cost);
		OrderDao dao = new OrderDaoImpl();
		dao.add(order);
		response.sendRedirect("manage/manage-result.jsp");
	}

}
