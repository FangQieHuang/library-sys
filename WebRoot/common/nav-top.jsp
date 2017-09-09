<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入JSTL核心标签库 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
%>
<!-- /. NAV TOP  -->
<nav class="navbar-default navbar-side" role="navigation">
<div class="sidebar-collapse">
	<ul class="nav" id="main-menu">
		<li>
			<div class="user-img-div">
				<img src="<%=path%>/assets/img/qq.png" class="img-thumbnail" />

				<div class="inner-text">
					<h5>
						姓名 ${user.name }   
					</h5>
					<h5>
						用户名 ${user.username } 
					</h5>
					<h5>
						欢迎您的到来
					</h5>
					<!--    <small>Last Login : 2 Weeks Ago </small>  -->
				</div>
			</div>
		</li>


		<li>
			<a class="" href="<%=path%>/page/index.jsp"><i class="fa fa-desktop "></i>首页</a>
		</li>
		
		<!-- 如果登陆的人 是 借阅者，则不给用户管理按钮   user.role!='borrower' -->
		<c:if test="${user != null}" >
			<c:if test="${user.role != 'borrower' && user.role != 'libAdmin'}">
				<li>
					<a class="" href="<%=path%>/page/user-manager.jsp">
						<i class="fa fa-square-o "></i>用户管理</span>
					</a>
				</li>
			</c:if>
		</c:if>
	
		<li>
			<a href="<%=path%>/findAllBookServlet"><i class="fa fa-square-o "></i>图书管理</a>
		</li>
	
		<li>
			<a href="#"><i class="fa fa-sitemap "></i>借阅模块 <span
				class="fa arrow"></span> </a>
			<ul class="nav nav-second-level">
				<li>
					<a href="<%=path%>/findAllBorrowServlet"><i class="fa fa-bicycle "></i>修改借阅表</a>
				</li>
			
			</ul>
		</li>

		<li>
			<a href="#"><i class="fa fa-send"></i>回到页顶</a>
		</li>
	</ul>

</div>

</nav>

