package com.library.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;









import com.library.domian.User;
import com.library.service.UserService;
import com.library.service.impl.UserServiceImpl;
import com.library.utils.JsonUtils;



/**
 * 
 * @ClassName FindUserByUsernameServlet
 * @Description 通过用户名 查找用户
 * @author 黄洁芳
 * @date 2017年6月18日
 */
public class FindUserByUsernameServlet extends HttpServlet {

	// 创建一个 user 服务层实现
	UserService userService=new UserServiceImpl();
	
	public  void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("----- 进来了 --FindUserByUsernameServlet--- ");
		
		// 得到当前登陆的用户
		User _user_ = (User) request.getSession().getAttribute("user");
		// 初始化跳转路径
		String path="/login.jsp";
		if(_user_ == null || "".equals( _user_ )){
			// 还没登陆 跳转导登陆页面
			request.getRequestDispatcher(path).forward(request, response);
			return ;
		}
		System.out.println("当前用户 : " + _user_);
		
		try {
			
			String username = request.getParameter("username");
			User user = userService.findUserByUsername( username );
			System.out.println(user);
			response.getWriter().print( user != null ? JsonUtils.objectToJson(user) : null );
			
		} catch (Exception e) {
			// 打印错误信息
			e.printStackTrace();
		} finally {
			System.out.println("----- 出去了 --FindUserByUsernameServlet--- ");
		}
	}

}
