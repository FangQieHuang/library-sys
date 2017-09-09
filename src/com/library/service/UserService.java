package com.library.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.library.domian.User;
import com.library.utils.Page;
import com.library.utils.UUIDUtil;

public interface UserService {
	/**
	 * 检验用户名密码是否正确
	 * @param username
	 * @param password
	 * @return
	 */
	User checkUser(String username, String password) ;

	/**
	 * 添加用户
	 */
	User add(User user) ;
	
	/**
	 * 通过用户id ，查找用户
	 */
	User findUserById(String userId) ;

	/**
	 * 更新用户信息
	 */
	User update(User user) ;

	/**
	 * (分页查找)
	 * 查找出所有用户
	 */
	 Page findPage(String role,int page , int rows) ;

	/**
	 * 通过 ids 批量删除 
	 */
	boolean delete(String[] ids) ;

	/**
	 * 通过用户名查找用户
	 */
	User findUserByUsername(String username) ;
}
