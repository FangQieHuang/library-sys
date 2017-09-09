package com.library.servlet.libAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.library.domian.Book;
import com.library.service.BookService;
import com.library.service.impl.BookServiceImpl;




public class EditBookServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Book book = new Book();
		try {
			BeanUtils.populate(book, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BookService bs = new BookServiceImpl();
		bs.editBook(book);
		System.out.println(book.getBookname());
		//分发重定向
		response.sendRedirect("/library/findAllBookServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
