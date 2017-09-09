<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css" />

</HEAD>
<body>
	<br>
	
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>借阅情况表</strong>
					</TD>
				</tr>
				<tr>
					
		
				
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="24%">工号</td>
								<td align="center" width="18%">书籍编号</td>
								<td align="center" width="9%">数量</td>
								<td align="center" width="9%">状态</td>
								<td width="8%" align="center">使用者编号</td>
								
							
								<!-- 如果登陆的人 是 借阅者，则不显示删除按钮   user.role!='borrower' -->
								<c:if test="${user != null}" >
									<c:if test="${user.role != 'borrower'}">
										<!-- 删除 -->
										<td width="8%" align="center">修改</td>
									</c:if>
								</c:if>
								
							
							
							</tr>

			<c:forEach items="${Borrows}" var="b">							
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="23%">${b.userId}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${b.isbn }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${b.number }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${b.state }</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${b.id }</td>
								
								
								<!-- 如果登陆的人 是 借阅者，则不显示修改按钮   user.role!='borrower' -->
									<c:if test="${user != null}" >
										<c:if test="${user.role != 'borrower'}">
											<!-- 修改 -->
											<td align="center" style="HEIGHT: 22px" width="7%"><a
												href="${pageContext.request.contextPath}/infoBorrowServlet?id=${b.id }">
													<img
													src="${pageContext.request.contextPath}/images/i_edit.gif"
													border="0" style="CURSOR: hand"> </a>
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

