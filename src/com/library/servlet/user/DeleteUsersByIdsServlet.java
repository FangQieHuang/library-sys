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
 * @ClassName DeleteUsersByIdsServlet
 * @Description 删除用户
 * @author 黄洁芳
 * @date 2017年6月18日
 */
public class DeleteUsersByIdsServlet extends HttpServlet {

	// 创建一个 user 服务层实现
	UserService userService=new UserServiceImpl();

	public  void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("----- 进来了 --DeleteUsersByIdsServlet--- ");
		
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
			// 得到要删除的ids
			String idsString = request.getParameter("ids");
			String[] ids = JsonUtils.jsonToPojo(idsString, String[].class);
			System.out.println(ids.length);
			response.getWriter().print( userService.delete( ids ) ? true : false );
		} catch (Exception e) {
			// 打印错误信息
			e.printStackTrace();
		} finally {
			System.out.println("----- 出去了 --DeleteUsersByIdsServlet--- ");
		}
	}

}
