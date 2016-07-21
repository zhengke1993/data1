package com.yimai.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.Dao.CommentDao;
import com.yimai.Dao.impl.CommentDaoImpl;

public class CommentReplyServlet extends HttpServlet {

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
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String replyContent = request.getParameter("replyContent");

		CommentDao dao = new CommentDaoImpl();
		response.setCharacterEncoding("GBK");
		dao.reply(orderId, replyContent);
		response.sendRedirect("manage/manage-result.jsp");
	}

}
