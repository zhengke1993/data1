package com.yimai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.Dao.OrderDao;
import com.yimai.Dao.impl.OrderDaoImpl;

public class OrderDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("GBK");
		int id = Integer.parseInt(request.getParameter("id"));
		OrderDao dao = new OrderDaoImpl();
		dao.deleteById(id);
		response.sendRedirect("manage/manage-result.jsp");
	}

}
