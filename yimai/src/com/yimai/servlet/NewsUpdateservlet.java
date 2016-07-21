package com.yimai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.Dao.NewsDao;
import com.yimai.Dao.impl.NewsDaoImpl;
import com.yimai.entity.News;

public class NewsUpdateservlet extends HttpServlet {
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
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		response.setCharacterEncoding("GBK");
		News news = new News(id, title, content, null);
		NewsDao dao = new NewsDaoImpl();
		dao.update(news);
		response.sendRedirect("manage/manage-result.jsp");
	}

}
