<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<nav class="navbar navbar-default navbar-cls-top " role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".sidebar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="auth">Be Thinking</a>
	</div>

	<div class="header-right">
		<a href="<%=path%>/logout" class="btn btn-danger" title="退出登陆">
			<i class="fa fa-exclamation-circle fa-2x"></i> 
		</a>
	</div>
</nav>