<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.yimai.entity.ProductItem"%>
<%@page import="com.yimai.entity.ProductItem"%>
<jsp:directive.page import="com.yimai.Dao.impl.ProductDaoImpl" />
<jsp:directive.page import="com.yimai.entity.Product" />
<jsp:directive.page import="com.yimai.Dao.ProductDao" />
<jsp:directive.page import="com.yimai.entity.User" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>易买网商品展示</title>
    
	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="scripts/function.js"></script>

  </head>
  
  <body>
    <div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
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
	您现在的位置：<a href="index.html">易买网</a> &gt; <a href="product-list.html">图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<dt>图书音像</dt>
				<dd><a href="product-list.html">图书</a></dd>
				<dd><a href="product-list.html">音乐</a></dd>
				<dt>百货</dt>
				<dd><a href="product-list.html">运动健康</a></dd>
				<dd><a href="product-list.html">服装</a></dd>
				<dd><a href="product-list.html">家居</a></dd>
				<dd><a href="product-list.html">美妆</a></dd>
				<dd><a href="product-list.html">母婴</a></dd>
				<dd><a href="product-list.html">食品</a></dd>
				<dd><a href="product-list.html">手机数码</a></dd>
				<dd><a href="product-list.html">家具首饰</a></dd>
				<dd><a href="product-list.html">手表饰品</a></dd>
				<dd><a href="product-list.html">鞋包</a></dd>
				<dd><a href="product-list.html">家电</a></dd>
				<dd><a href="product-list.html">电脑办公</a></dd>
				<dd><a href="product-list.html">玩具文具</a></dd>
				<dd><a href="product-list.html">汽车用品</a></dd>
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<%
							List<ProductItem> list = (List) session.getAttribute("viewhistory");
							if (list != null) {
								for (int i = 0; i < list.size(); i++) {
									ProductItem pi = list.get(i);
						%>
						<dt>
							<img width="40px"
								src="images/product/<%=pi.getPto().getEp_file_name()%>" />
						</dt>
						<dd>
							<a href="product-view.jsp?id=<%=pi.getPto().getEp_id()%>"><%=pi.getPto().getEp_description()%></a>
						</dd>


						<%
							}
							}
						%>
		</div>
	</div>
	<div class="main">
		<div class="product-list">
			<h2>全部商品</h2>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="#">上一页</a></li>
					<li class="current">1</li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">下一页</a></li>
				</ul>
			</div>
			<div class="clear"></div>
			<ul class="product clearfix">
				<%
							ProductDao prodao = new ProductDaoImpl();
							List<Product> prodlist = new ArrayList<Product>();
							prodlist = prodao.getAll();

							for (int i = 0; i < prodlist.size(); i++) {
								Product pro = new Product();
								pro = prodlist.get(i);
						%>
						<li>
							<dl>
								<dt>
									<a href="product-view.jsp?id=<%=pro.getEp_id()%>"
										target="_blank"><img
											src="images/product/<%=pro.getEp_file_name()%>" /> </a>
								</dt>
								<dd class="title">
									<a href="product-view.jsp?id=<%=pro.getEp_id()%>"
										target="_blank"><%=pro.getEp_name()%></a>
								</dd>
								<dd class="price">
									￥<%=pro.getEp_price()%></dd>
							</dl>
						</li>
						<%
							}
						%>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="#">上一页</a></li>
					<li class="current">1</li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">下一页</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>

  </body>
</html>
