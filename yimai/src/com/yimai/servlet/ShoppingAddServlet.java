package com.yimai.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yimai.Dao.impl.ProductDaoImpl;
import com.yimai.entity.Product;
import com.yimai.entity.ProductItem;

public class ShoppingAddServlet extends HttpServlet {

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
		ProductDaoImpl dao = new ProductDaoImpl();
		Product p = dao.getById(id);

		HttpSession session = request.getSession();
		List<ProductItem> list = (List) session.getAttribute("crt");
		ProductItem pros = null;
		boolean fang = true;
		if (list == null) {
			list = new ArrayList<ProductItem>();
		} else {
			for (int d = 0; d < list.size(); d++) {
				pros = list.get(d);
				if (pros.getPto().getEp_id() == id) {
					pros.setNum(pros.getNum() + 1);
					fang = false;
					break;
				}
			}
		}
		if (fang) {
			pros = new ProductItem(p, 1);
			list.add(pros);
		}
		session.setAttribute("crt", list);
		response.sendRedirect("shopping.jsp");
	}
	}


