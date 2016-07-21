package com.yimai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.Dao.impl.UserDaoImpl;
import com.yimai.entity.User;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
		User user = new User();
		user.setEu_user_id(request.getParameter("userName"));
		String pass = request.getParameter("passWord");
		String rpass = request.getParameter("rePassWord");
		user.setEu_password(pass);
		PrintWriter out = response.getWriter();
		if (!pass.equals(rpass)) {
			out.print("<script type=text/javascript> alert('两次密码不一样！');location.href='register.jsp'</script>");
			return;
		}
		UserDaoImpl dao = new UserDaoImpl();
		boolean flag=false;
		flag=dao.check(user.getEu_user_id());
		if(flag==true){
			out.print("<script type=text/javascript> alert('用户已存在！');location.href='register.jsp'</script>");
		}else{
			dao.addUser(user);
			response.sendRedirect("reg-result.jsp");
		}
	}

}
