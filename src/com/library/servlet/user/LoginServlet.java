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
 * @ClassName LoginServlet
 * @Description 实现用户登陆校验
 * @author 黄洁芳
 * @date 2017年6月18日
 */
public class LoginServlet extends HttpServlet {

	// 创建一个 user 服务层实现
	UserService userService=new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("----- 进来了 --LoginServlet--- ");
		// 获取 form表单提交的 用户名 和 密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		 
		// 初始化跳转路径
		String path="";
		
		try {

			// 校验用户名和密码是否正确 ， 正确得到  用户信息 ， 否则返回 null
			User u = userService.checkUser(username, password) ;
			
			if( u != null ){
				System.out.println("校验成功 ： 登陆用户为 : " + u);
				// 认证成功
				// 如果 session 中 有之前的错误信息，要删除掉
				request.getSession().setAttribute( "loginWrong", null );
				// 设置跳转到首页
				path="/page/index.jsp";
				
				// 校验成功 ， 将用户信息保存在 session 中
				request.getSession().setAttribute("user", u );
				
			}else{
				System.out.println("校验失败，用户名或密码错误 ");
				// 将验证错误信息 放入 session中
				String wrongStr = "验证失败，用户名或者密码错误" ;
				request.getSession().setAttribute( "loginWrong", wrongStr );
				// 设置验证失败 跳转路径为 返回登陆页面
				path="/login.jsp";
			}
		} catch (Exception e) {
			// 打印错误信息
			e.printStackTrace();
		} finally {
			System.out.println("----- 出去了 --LoginServlet--- ");
			// 执行跳转
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	public  void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 调用 doGet 方法实现
		doGet(request, response);
	}

}
