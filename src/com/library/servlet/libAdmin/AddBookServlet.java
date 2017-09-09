package com.library.servlet.libAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;



import com.library.domian.Book;
import com.library.domian.User;
import com.library.service.BookService;
import com.library.service.impl.BookServiceImpl;
import com.library.utils.UUIDUtil;



public class AddBookServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取表单数据
		Book book = new Book();
		try {
			BeanUtils.populate(book, request.getParameterMap());
			book.setId(UUIDUtil.getUUID());//手动生成一个随机ID
		} catch (Exception e) {
			e.printStackTrace();
		}
		//调用业务逻辑
		BookService bs = new BookServiceImpl();
		bs.addBook(book);
		//分发重定向
		response.sendRedirect("/library/findAllBookServlet");
		
	}

	
	public  void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
