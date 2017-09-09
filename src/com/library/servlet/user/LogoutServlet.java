package com.library.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.library.domian.User;
import com.library.service.UserService;
import com.library.service.impl.UserServiceImpl;



/**
 * 
 * @ClassName LogoutServlet
 * @Description 实现用户注销登陆
 * @author 黄洁芳
 * @date 2017年6月18日
 */
public class LogoutServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("----- 进来了 --LogoutServlet--- ");
		
		// 将 session 中的用户信息 设置为 null
		request.getSession().setAttribute("user",null);
		// 初始化跳转路径
		String path="/login.jsp";
		request.getRequestDispatcher(path).forward(request, response);

		System.out.println("----- 出去了 --LogoutServlet--- ");
	}

}
