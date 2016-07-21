<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.yimai.Dao.NewsDao" />
<jsp:directive.page import="com.yimai.Dao.impl.NewsDaoImpl" />
<jsp:directive.page import="com.yimai.entity.News" />
<jsp:directive.page import="com.yimai.entity.User" />

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>易买网阅读新闻</title>
    
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
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 阅读新闻
</div>
<div id="main" class="wrap">
	<div class="left-side">
		<div class="news-list">
			<h4>最新公告</h4>
			
			<ul><%
							List<News> list = new ArrayList<News>();
							NewsDao dao = new NewsDaoImpl();
							list = dao.getAll();
							for (int i = 0; i < list.size(); i++) {
								News news = new News();
								news = list.get(i);
						%>
						<li>
						
							<a href="news-view.jsp" target="_blank"><%=news.getEn_title() %></a>
						</li>	
						<%
							}
						%>	
					</ul>
					
		</div>
		<div class="spacer"></div>
		<div class="news-list">
			<h4>新闻动态</h4>
			<ul>
				<%
							list = dao.getAll();
							for (int i = 0; i < list.size(); i++) {
								News news = new News();
								news = list.get(i);
						%>
						<li>
							<a href="news-view.jsp" target="_blank"><%=news.getEn_title()%></a>
						</li>		
						<%
							}
						%>
					</ul>
					
		</div>
	</div>
	<div class="manage">
	<table class="list">
				<tr>
					<th>新闻标题</th>
					<th>新闻内容</th>
					<th>新闻时间</th>
				</tr>
				<tr>
			  <%
							list = dao.getAll();
							for (int i = 0; i < list.size(); i++) {
								News news = new News();
								news = list.get(i);
						%>
					<td ><%=news.getEn_title()%></td>
					<td><%=news.getEn_content()%></td>
					<td class="first w4 c"><%=news.getEn_create_time() %></td>
				</tr>
				<%
							}
						%>
			</table>
	<div class="clear"></div>
</div>

  </body>
</html>