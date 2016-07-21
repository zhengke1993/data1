<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:directive.page import="com.yimai.Dao.NewsDao" />
<jsp:directive.page import="com.yimai.Dao.impl.NewsDaoImpl" />
<jsp:directive.page import="com.yimai.entity.News" />
<jsp:directive.page import="com.yimai.entity.Product" />
<jsp:directive.page import="com.yimai.Dao.ProductDao" />
<%@page import="com.yimai.entity.ProductItem"%>
<jsp:directive.page import="com.yimai.Dao.impl.ProductDaoImpl" />
<jsp:directive.page import="com.yimai.entity.User" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>易买网首页</title>
	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="scripts/function.js"></script>
  </head>
  
  <body>
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
				欢迎您：<%=user.getEu_user_name()%><a href="UserLogoutServlet">[注销登录]</a><a
					href="shopping.jsp" class="shopping">购物车</a><a href="guestbook.jsp">留言</a>
			</div>
			<%
				}
			%>
		<div class="navbar">
				<ul class="clearfix">
					<li class="current">
			<li class="current"><a href="index.jsp">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
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
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="price-off">
			<h2>今日特价</h2>
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
		</div>
		<div class="side">
			<div class="news-list">
				<h4>最新公告</h4>
			
			<ul><%
							List<News> nlist = new ArrayList<News>();
							NewsDao dao = new NewsDaoImpl();
							nlist = dao.getAll();
							for (int i = 0; i < nlist.size(); i++) {
								News news = new News();
								news = nlist.get(i);
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
							nlist = dao.getAll();
							for (int i = 0; i < nlist.size(); i++) {
								News news = new News();
								news = nlist.get(i);
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
		<div class="spacer clear"></div>
		<div class="hot">
			<h2>热卖推荐</h2>
			<ul class="product clearfix">
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/1.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">法国德菲丝松露精品巧克力500g/盒</a></dd>
						<dd class="price">￥108.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/2.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">乐扣普通型保鲜盒圣诞7件套</a></dd>
						<dd class="price">￥69.90</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/3.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">欧珀莱均衡保湿四件套</a></dd>
						<dd class="price">￥279.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/4.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">联想笔记本电脑 高速独立显存</a></dd>
						<dd class="price">￥4199</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/5.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">法姿韩版显瘦彩边时尚牛仔铅笔裤</a></dd>
						<dd class="price">￥49.00</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/6.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">Genius925纯银施华洛世奇水晶吊坠</a></dd>
						<dd class="price">￥69.90</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/7.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">利仁2018M福满堂电饼铛 好用实惠</a></dd>
						<dd class="price">￥268.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/8.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">达派高档拉杆箱20寸 经典款式</a></dd>
						<dd class="price">￥198.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/9.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">爱国者MP4 全屏触摸多格式播放 4G</a></dd>
						<dd class="price">￥289.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/10.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">多美滋金装金盾3阶段幼儿配方奶粉</a></dd>
						<dd class="price">￥186.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/1.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">法国德菲丝松露精品巧克力500g/盒</a></dd>
						<dd class="price">￥108.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.jsp" target="_blank"><img src="images/product/2.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_blank">乐扣普通型保鲜盒圣诞7件套</a></dd>
						<dd class="price">￥69.90</dd>
					</dl>
				</li>
			</ul>
		</div>
	</div>
	<div class="clear"></div>
<br>
  </body>
</html>
