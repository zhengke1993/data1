package com.yimai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.Dao.CommentDao;
import com.yimai.Dao.impl.CommentDaoImpl;
import com.yimai.entity.Comment;

public class CommentAddServlet extends HttpServlet {

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
		String ecnickname = request.getParameter("guestName");
		String eccontent = request.getParameter("guestContent");
		Comment com = new Comment();
		com.setEc_nick_name(ecnickname);
		com.setEc_content(eccontent);
		CommentDao dao = new CommentDaoImpl();
		dao.addComment(com);
		response.sendRedirect("manage/guestbook.jsp");
	}

}
