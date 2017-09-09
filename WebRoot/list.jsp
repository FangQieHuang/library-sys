<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/add.jsp";
	}
	function deleBook(id,bookname){
		if(confirm("是否确定删除"+bookname+"?")){
			location.href="${pageContext.request.contextPath}/deleteBookServlet?id="+id;
		}
	}
	
</script>
</HEAD>
<body>
	<br>
	
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>图书列表</strong>
					</TD>
				</tr>
				
				
				<!-- 如果登陆的人 是 借阅者，则不显示添加按钮   user.role!='borrower' -->
				<c:if test="${user != null}" >
					<c:if test="${user.role != 'borrower'}">
						<!-- 修添加-->
						<tr>
							<td class="ta_01" align="right">
								<button type="button" id="add" name="add" value="&#28155;&#21152;"
									class="button_add" onclick="addProduct()">&#28155;&#21152;
								</button>
							</td>
						</tr>
					</c:if>
				</c:if>
				
				
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="24%">书籍编号</td>
								<td align="center" width="18%">书籍名称</td>
								<td align="center" width="9%">出版社</td>
								<td align="center" width="9%">出版日期</td>
								<td width="8%" align="center">价格</td>
								<td align="center" width="9%">数量</td>
								
								<!-- 如果登陆的人 是 借阅者，则不显示修改按钮   user.role!='borrower' -->
								<c:if test="${user != null}" >
									<c:if test="${user.role != 'borrower'}">
										<!-- 修改 -->
										<td width="8%" align="center">编辑</td>
									</c:if>
								</c:if>
								<!-- 如果登陆的人 是 借阅者，则不显示删除按钮   user.role!='borrower' -->
								<c:if test="${user != null}" >
									<c:if test="${user.role != 'borrower'}">
										<!-- 删除 -->
										<td width="8%" align="center">删除</td>
									</c:if>
								</c:if>
								
							</tr>

			<c:forEach items="${books}" var="b">							
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="23%">${b.id }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${b.bookname }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${b.publication }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${b.pubdate }</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${b.price }</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${b.number }</td>
									
									
									<!-- 如果登陆的人 是 借阅者，则不显示修改按钮   user.role!='borrower' -->
									<c:if test="${user != null}" >
										<c:if test="${user.role != 'borrower'}">
											<!-- 修改 -->
											<td align="center" style="HEIGHT: 22px" width="7%"><a
												href="${pageContext.request.contextPath}/infoBookServlet?id=${b.id }">
													<img
													src="${pageContext.request.contextPath}/images/i_edit.gif"
													border="0" style="CURSOR: hand"> </a>
											</td>
										</c:if>
									</c:if>
									
									<!-- 如果登陆的人 是 借阅者，则不显示删除按钮   user.role!='borrower' -->
									<c:if test="${user != null}" >
										<c:if test="${user.role != 'borrower'}">
											<!-- 删除 -->
											<td align="center" style="HEIGHT: 22px" width="7%"><a
												href="javascript:deleBook('${b.id}','${b.bookname }')">
													<img
													src="${pageContext.request.contextPath}/images/i_del.gif"
													width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</c:if>
									</c:if>
									
									
									
								</tr>
					</c:forEach>	
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
		<a class="" href="${pageContext.request.contextPath}/page/index.jsp"><i class="fa fa-desktop "></i>返回首页</a>
	
</body>
</HTML>

