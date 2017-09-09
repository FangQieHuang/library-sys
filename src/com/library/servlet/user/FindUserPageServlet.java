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
import com.library.utils.Page;



/**
 * 
 * @ClassName FindUserPageServlet
 * @Description 分页查找用户
 * @author 黄洁芳
 * @date 2017年6月18日
 */
public class FindUserPageServlet extends HttpServlet {

	// 创建一个 user 服务层实现
	UserService userService=new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("----- 进来了 --FindUserPageServlet--- ");
		
		// 得到当前登陆的用户
		User _user_ = (User) request.getSession().getAttribute("user");
		// 初始化跳转路径
		String path="/login.jsp";
		if(_user_ == null || "".equals( _user_ )){
			// 还没登陆 跳转导登陆页面
			request.getRequestDispatcher(path).forward(request, response);
		}
		System.out.println("当前用户 : " + _user_);
		
		
		Page page = null ;
		try {
			User user = (User) request.getSession().getAttribute("user");
			
			// 得到要 查询的页码
			int pageNum = Integer.valueOf( request.getParameter("page") ) ;
			// 得到 每页的 信息 条数
			int rows = Integer.valueOf( request.getParameter("rows") ) ;
			System.out.println( "正在查询的页码 : " + pageNum );
			System.out.println( "正在查询的每页条数 : " + rows );
			
			// 得到所有用户信息
			/*users = userService.findAll( user.getRole());*/
			
			// 得到当前页面信息
			page = userService.findPage( user.getRole() , pageNum , rows );
				
		} catch (Exception e) {
			// 打印错误信息
			e.printStackTrace();
		} finally {
			// 当前页面信息 转化成 json 字符串 返回给页面
			response.getWriter().write( JsonUtils.objectToJson(page) );
			System.out.println("----- 出去了 --FindUserPageServlet--- ");
		}
	}

}
