<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


</HEAD>

<body>
	<form id="userAction_save_do" name="Form1" 
	action="${pageContext.request.contextPath}/editBookServlet" method="post" >
		&nbsp;
		<input type="hidden" name="id" value="${book.id }"/>
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor ="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>修改书籍</STRONG> </strong>
				</td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">书籍名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="bookname"
					value="${book.bookname }" class="bg"/>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">出版商：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="publication"
					value="${book.publication }" 
					class="bg" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">出版日期：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="pubdate"
					value="${book.pubdate }" 
					class="bg" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">价格：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="price"
					value="${book.price }" 
					class="bg" />
				</td>
			</tr>
			<TR>
				<td align="center" bgColor="#f5fafe" class="ta_01">数量：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="number"
					value="${book.number }" 
					class="bg" />
				</td>
			</TR>
			<TR>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/images/shim.gif">
				</td>
			</TR>


			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					
					
						
					<input type="submit" class="button_ok" value="确定">	
						
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					
					
					
					<input type="reset" value="重置" class="button_cancel">

					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1">
					
					</span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>