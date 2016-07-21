package com.yimai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.Dao.UserDao;
import com.yimai.Dao.impl.UserDaoImpl;
import com.yimai.entity.User;

public class UserLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		UserDao dao =  new UserDaoImpl();
		boolean flag = true;
		flag = dao.login(username, password);
		if (flag) {
			User user = new User();
			user = dao.getById(username);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("index.jsp");
			
		} else {
			
			out.print("<script type=text/javascript> alert('用户名或密码错误');location.href='login.jsp'</script>");
		}

	}

}
