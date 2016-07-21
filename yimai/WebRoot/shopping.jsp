<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.yimai.entity.ProductItem"%>
<%@page import="com.yimai.entity.User"%>
<jsp:directive.page import="com.yimai.entity.User" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	User user =null;
	user = (User)session.getAttribute("user");
	if(user==null)
	{	out.print("<script type=text/javascript> alert('请先登录！');location.href='login.jsp'</script>");
					return;
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>易买网购物车</title>
    
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js">
</script>
  </head>
  
  <body>
<div id="header" class="wrap">
	<div id="logo"><a href="index.jsp"><img src="images/logo.gif" /></a></div>
	<%
				
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
				欢迎您：<%=user.getEu_user_name()%><a href="UserLogoutServlet">[注销登录]</a><a
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
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="shopping-result.jsp">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<%
							List<ProductItem> list = (List) session.getAttribute("crt");
							ProductItem pr = new ProductItem();
							if (list != null) {
								for (int i = 0; i < list.size(); i++) {
									pr = list.get(i);
									
						%>
				<tr id="product_id_1">
					<td class="thumb"><img src="images/product/<%=pr.getPto().getEp_file_name()%>" /><a text=""><%=pr.getPto().getEp_name()%></a></td>
					<td class="price" id="price_id_1">
						<span>￥<%=pr.getPto().getEp_price() * pr.getNum()%></span>
						<input type="hidden" value="99" />
					</td>
					<td class="number">
						<dl>
							<dt><input id="number_id_1" type="text" name="number" value="<%=pr.getNum()%>" /></dt>
							<dd onclick="./ShoppingUpdateServlet?num=<%=pr.getNum()%>)&id=<%=pr.getPto().getEp_id()%>">修改</dd>
						</dl>
					</td>
					<td class="delete"><a href="./ShoppingDeleteServlet?id=<%=pr.getPto().getEp_id()%>">删除</a></td>
				</tr>
				<%
							}
							} else {
						%>
						<tr align="center">
							<td style="font-size: 30px;" >
								购物车里什么都没有
							</td>
						</tr>
						<%
							}
						%>
			</table>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
	<script type="text/javascript">
		<%
							List<ProductItem> vlist = (List) session.getAttribute("viewhistory");
							if (list != null) {
								for (int i = 0; i < vlist.size(); i++) {
									ProductItem pi = vlist.get(i);
						%>
						<dt>
							<img width="40px" src="images/product/<%=pi.getPto().getEp_file_name()%>" />
						</dt>
						<dd>
							<a href="product-view.jsp?id=<%=pi.getPto().getEp_id()%>"><%=pi.getPto().getEp_description()%></a>
						</dd>


						<%
							}
							}
						%>
	</script>
  </body>
</html>
