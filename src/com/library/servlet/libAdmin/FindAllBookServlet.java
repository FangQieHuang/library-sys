package com.library.servlet.libAdmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.domian.Book;
import com.library.service.BookService;
import com.library.service.impl.BookServiceImpl;


public class FindAllBookServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		BookService bookService=new BookServiceImpl();
		List<Book> list=bookService.listAllBook();
		//跳转页面
		request.setAttribute("books",list);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		
	}

	
	public  void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
