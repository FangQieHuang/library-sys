package com.library.servlet.borrow;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.library.domian.Borrow;

import com.library.service.BorrowService;

import com.library.service.impl.BorrowServiceImpl;





public class EditBorrowServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Borrow borrow = new Borrow();
		try {
			BeanUtils.populate(borrow, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BorrowService bs = new BorrowServiceImpl();
		bs.editBorrow(borrow);
		System.out.println(borrow.getUserId());
		System.out.println(borrow.getId());
		System.out.println(borrow.getIsbn());
		System.out.println(borrow.getNumber());
		System.out.println(borrow.getState());
		//分发重定向
		response.sendRedirect("/library/findAllBorrowServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
