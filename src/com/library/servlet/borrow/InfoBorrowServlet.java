package com.library.servlet.borrow;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.domian.Borrow;
import com.library.service.BorrowService;
import com.library.service.impl.BorrowServiceImpl;



public class InfoBorrowServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//获取表单数据
		String id=request.getParameter("id");
		
		//调用业务逻辑
		BorrowService bs=new BorrowServiceImpl();
		Borrow borrow=bs.findBorrowById(id);
		//分发转向
		request.setAttribute("borrow", borrow);
		request.getRequestDispatcher("/edit1.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
