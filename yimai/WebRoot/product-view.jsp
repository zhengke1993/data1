<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.yimai.entity.Product" />
<jsp:directive.page import="com.yimai.Dao.ProductDao" />
<jsp:directive.page import="com.yimai.Dao.impl.ProductDaoImpl" />
<%@page import="com.yimai.entity.ProductItem"%>
<jsp:directive.page import="com.yimai.entity.User" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>易买网详细商品</title>
    
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>

  </head>
  
  <body>
    <div id="header" class="wrap">
	<div id="logo"><a href="index.jsp"><img src="images/logo.gif" /></a></div>
	<%
				User user = new User();
				user = (User) session.getAttribute("user");
				if (user == null) {
			%>
			<div class="help">
				<a href="shopping.jsp" class="shopping">购物车</a><a href="login.jsp">登录</a><a
					href="register.jsp">注册</a><a href="guestbook.jsp">留言</a>
			</div>
		
			<%
				} else {
			%>


			<div class="help">
				欢迎您：<%=user.getEu_user_id()%><a href="UserLogoutServlet">[注销登录]</a><a
					href="shopping.jsp" class="shopping">购物车</a><a href="guestbook.jsp">留言</a>
			</div>
			<%
				}
			%>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="#">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; <a href="product-list.jsp">图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<dt>图书音像</dt>
				<dd><a href="product-list.jsp">图书</a></dd>
				<dd><a href="product-list.jsp">音乐</a></dd>
				<dt>百货</dt>
				<dd><a href="product-list.jsp">运动健康</a></dd>
				<dd><a href="product-list.jsp">服装</a></dd>
				<dd><a href="product-list.jsp">家居</a></dd>
				<dd><a href="product-list.jsp">美妆</a></dd>
				<dd><a href="product-list.jsp">母婴</a></dd>
				<dd><a href="product-list.jsp">食品</a></dd>
				<dd><a href="product-list.jsp">手机数码</a></dd>
				<dd><a href="product-list.jsp">家具首饰</a></dd>
				<dd><a href="product-list.jsp">手表饰品</a></dd>
				<dd><a href="product-list.jsp">鞋包</a></dd>
				<dd><a href="product-list.jsp">家电</a></dd>
				<dd><a href="product-list.jsp">电脑办公</a></dd>
				<dd><a href="product-list.jsp">玩具文具</a></dd>
				<dd><a href="product-list.jsp">汽车用品</a></dd>
			</dl>
		</div>
	</div>
	<div id="product" class="main">
	    <%
					int id = Integer.parseInt(request.getParameter("id"));
					Product pro = new Product();
					ProductDao dao = new ProductDaoImpl();
					pro = dao.getById(id);
					List<ProductItem> viewhistory = (List) session.getAttribute("viewhistory");
					boolean flag = true;
					if (viewhistory == null) {
						viewhistory = new ArrayList<ProductItem>();
					}
					for (int i = 0; i < viewhistory.size(); i++) {
						if (viewhistory.get(i).getPto().getEp_id() == id) {
							flag = false;
							break;
						}
					}
					if (flag) {
						ProductItem viewitem = new ProductItem(pro, 1);
						viewhistory.add(viewitem);
						session.setAttribute("viewhistory", viewhistory);

					}
				%>
	
		<h1><%=pro.getEp_name()%></h1>
		<div class="infos">
			<div class="thumb"><img src="images/product/<%=pro.getEp_file_name()%>" /></div>
			<div class="buy">
				<p>商城价：<span class="price">￥<%=pro.getEp_price()%></span></p>
				<p>库　存：<%=pro.getEp_stock() %></p>
				<div class="button"><input type="button" name="button" value="" onclick="goBuy(1)" /><a href="ShoppingAddServlet?id=<%=pro.getEp_id()%>">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				<%=pro.getEp_description() %>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
  </body>
</html>
