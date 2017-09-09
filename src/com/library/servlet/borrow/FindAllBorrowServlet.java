package com.library.servlet.borrow;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.domian.Borrow;
import com.library.service.BorrowService;
import com.library.service.impl.BorrowServiceImpl;


public class FindAllBorrowServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		BorrowService borrowService=new BorrowServiceImpl();
		List<Borrow> list=borrowService.listAllBorrow();
		//跳转页面
		request.setAttribute("Borrows",list);
		request.getRequestDispatcher("/list1.jsp").forward(request, response);
		
	}

	
	public  void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
