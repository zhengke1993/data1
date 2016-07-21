package com.yimai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.Dao.impl.UserDaoImpl;
import com.yimai.entity.User;

public class UserAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
		
		}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userName");
		String name=request.getParameter("name");
		String passWord=request.getParameter("passWord");
		String sex=request.getParameter("sex");
		//生日不会写
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		User ManageUser = new User();
		ManageUser.setEu_user_id(userId);
		ManageUser.setEu_user_name(name);
		ManageUser.setEu_password(passWord);
		ManageUser.setEu_sex(sex);
		ManageUser.setEu_mobile(mobile);
		ManageUser.setEu_address(address);
		UserDaoImpl dao = new UserDaoImpl();
		boolean flag=false;
		flag=dao.check(ManageUser.getEu_user_id());
		if(flag==true){
			out.print("<script type=text/javascript> alert('用户已存在');location.href='manage/user-add.jsp'</script>");
		}else{
			dao.addManageUser(ManageUser);
			response.sendRedirect("manage/manage-result.jsp");
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
