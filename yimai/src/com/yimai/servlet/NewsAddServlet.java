package com.yimai.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.Dao.NewsDao;
import com.yimai.Dao.impl.NewsDaoImpl;

public class NewsAddServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setContentType("text/html");
		request.setCharacterEncoding("GBK");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		NewsDao dao = new NewsDaoImpl();
		dao.addNews(title, content);
		response.sendRedirect("manage/manage-result.jsp");
	}

}