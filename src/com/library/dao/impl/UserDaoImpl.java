package com.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.library.dao.UserDao;
import com.library.domian.Book;
import com.library.domian.User;
import com.library.utils.C3P0Util;

/**
 * 
 * @ClassName UserDaoImpl
 * @Description user Dao 实现
 * @author 黄洁芳
 * @date 2017年6月18日
 */
public class UserDaoImpl implements UserDao{ 

	/**
	 * 通过用户名查找相应的用户
	 */
	@Override
	public User findByUsername(String username) {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		try {
			// 拼接 sql 语句
			String sql = "select * from user where username=? ;" ;
			// 执行查询，并告诉它，你查询得到的是 User 
			User user = qr.query( sql , new BeanHandler<User>(User.class),username);
			return user ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据当前用户的角色
	 * 查找所有用户
	 */
	@Override
	public List<User> findAll(String userRole) {
		
		/**
		 * 系统管理员可以 操作 图书管理员 和 借阅者
		 * 图书管理员可以 操作 借阅者
		 * 借阅者没有权限
		 */
		String sql = "";
		if( "sysAdmin".equals(userRole) ){
			sql = "select * from user where role != 'sysAdmin'" ;
		}else if( "libAdmin".equals(userRole) ){
			sql = "select * from user where role = 'borrower'" ;
		}else if( "borrower".equals(userRole) ){
			sql = "select * from user where 1 = 2" ;
		}else{
			sql = "select * from user where 1 = 2" ;
		}
		
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		List<User> users=null;
		try {
			users=qr.query( sql , 
					new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void add(User user) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		String sql = " INSERT INTO user ( id, name, workNumber, sex, workdate, username, password, role ) VALUES ";
		sql += "(  '" + user.getId() + "', '" + user.getName() + "', '" + user.getWorkNumber() + "', '"+user.getSex()+"', '"+user.getWorkdate()+"', '"+user.getUsername()+"', '"+user.getPassword()+"', '"+user.getRole()+"'  );" ;
		System.out.println("sql语句 = " + sql );
		
		try {
			qr.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过用户id ，查找用户
	 */
	@Override
	public User findUserById(String userId) {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		User user=null;
		try {
			user=qr.query("select * from user where id=?;", new BeanHandler<User>(User.class) , userId );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 更新用户
	 */
	@Override
	public void update(User user) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		try {
			qr.update("UPDATE user SET  username=?,password=?,name=?,workNumber=?,sex=?,workdate=?,role=? WHERE id=? ;",
					user.getUsername(),
					user.getPassword(),
					user.getName(),
					user.getWorkNumber(),
					user.getSex(),
					user.getWorkdate(),
					user.getRole(),
					user.getId()
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据当前用户的角色
	 * 分页查找
	 */
	@Override
	public List<User> findPage(String role, int startIndex, int rows) {
		
		/**
		 * 系统管理员可以 操作 图书管理员 和 借阅者
		 * 图书管理员可以 操作 借阅者
		 * 借阅者没有权限
		 */
		String sql = "select * from user ";
		if( "sysAdmin".equals(role) ){
			sql += " where role != 'sysAdmin' " ;
		}else if( "libAdmin".equals(role) ){
			sql += " where role = 'borrower'" ;
		}else if( " borrower".equals(role) ){
			sql += " where 1 = 2" ;
		}else{
			sql += " where 1 = 2" ;
		}
		
		//  SELECT * FROM * LIMIT 5,10;   第一个参数是 起始下标 ，第二个参数是 信息条数
		sql += " LIMIT " + startIndex + "," + rows + ";" ;
		
		System.out.println("发送的sql 语句 : " + sql);
		
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		List<User> users=null;
		try {
			users=qr.query( sql , 
					new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * 根据当前用户的角色 
	 * 查询可以操作的用户人数
	 */
	@Override
	public int findAllCount(String role) {
		/**
		 * 系统管理员可以 操作 图书管理员 和 借阅者
		 * 图书管理员可以 操作 借阅者
		 * 借阅者没有权限
		 */
 		String sql = "select count(id) as count from user ";
		if( "sysAdmin".equals(role) ){
			sql += " where role != 'sysAdmin' " ;
		}else if( "libAdmin".equals(role) ){
			sql += " where role = 'borrower'" ;
		}else if( " borrower".equals(role) ){
			sql += " where 1 = 2" ;
		}else{
			sql += " where 1 = 2" ;
		}

        Connection conn =null;
        Statement stmt = null;
        ResultSet rs= null;
		int totalNum = 0 ;
		
		try {
			// 获取链接
			conn = C3P0Util.getConnection() ;
			stmt = conn.createStatement();
			// 执行查询
			rs = stmt.executeQuery(sql);
			// 得到结果集
			rs.next();
			// 得到 count
			totalNum = Integer.valueOf( rs.getString("count") ) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalNum;
	}

	/**
	 * 通过id 删除用户
	 */
	@Override
	public void deleteByIds(String id) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			qr.update("DELETE  FROM user WHERE id=?",id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
