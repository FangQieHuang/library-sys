package com.library.servlet.libAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.domian.Book;
import com.library.service.BookService;
import com.library.service.impl.BookServiceImpl;



public class InfoBookServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//获取表单数据
		String id=request.getParameter("id");
		
		//调用业务逻辑
		BookService bs=new BookServiceImpl();
		Book book=bs.findBookById(id);
		//分发转向
		request.setAttribute("book", book);
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
