<%@ page language="java" import="java.util.*"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- head-start -->
<jsp:include page="/common/head.jsp"></jsp:include>
<!-- head-end -->

</head>
<body>
	<div id="wrapper">
		<!-- recommend-start -->
		<jsp:include page="/common/recommend.jsp"></jsp:include>
		<!-- recommend-end -->

		<!-- navigation top-start -->
		<jsp:include page="/common/nav-top.jsp"></jsp:include>
		<!-- navigation top-end -->

<!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line"></h1>
                        <h1 class="page-subhead-line">欢迎来到图书管理系统！！！</h1>

                    </div>
                </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->

    <div id="footer-sec" target="_blank">
        2017. BE THINKING 图书管理系统.
    </div>
    <!-- /. FOOTER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="<%=path %>/assets/js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="<%=path %>/assets/js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="<%=path %>/assets/js/jquery.metisMenu.js"></script>
       <!-- CUSTOM SCRIPTS -->
    <script src="<%=path %>/assets/js/custom.js"></script>
    


</body>
</html>
