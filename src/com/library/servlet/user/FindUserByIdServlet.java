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
 * @ClassName FindUserByIdServlet
 * @Description 通过用户id，查找用户
 * @author 黄洁芳
 * @date 2017年6月18日
 */
public class FindUserByIdServlet extends HttpServlet {

	// 创建一个 user 服务层实现
	UserService userService=new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("----- 进来了 --FindUserByIdServlet--- ");
		
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
		
		User user = null ;
		try {
			// 获取 用户id
			String userId = request.getParameter("userId");
			user = userService.findUserById( userId );
			System.out.println(user.toString());
		} catch (Exception e) {
			// 打印错误信息
			e.printStackTrace();
		} finally {
			// user 转化成 json 字符串 返回给页面
			response.getWriter().write( JsonUtils.objectToJson(user) );
			System.out.println("----- 出去了 --FindUserByIdServlet--- ");
		}
	}

}
