package com.library.service.impl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.dao.UserDao;
import com.library.dao.impl.UserDaoImpl;
import com.library.domian.User;
import com.library.service.UserService;
import com.library.utils.Page;
import com.library.utils.UUIDUtil;

/**
 * 
 * @ClassName UserServiceImpl
 * @Description user service层实现
 * @author 黄洁芳
 * @date 2017年6月18日
 */
public class UserServiceImpl implements UserService{

	/**
	 * 初始化 user daoimpl
	 */
	UserDao userDao=new UserDaoImpl();
	
	/**
	 * 检验用户名和密码是否正确
	 * 正确返回 相应的user对象 否则返回 null
	 */
	public User checkUser(String username, String password) {
		// 利用 用户名 ， 向数据库查询 用户
		User u =  userDao.findByUsername(username);
		// 三元表达式 ( u != null && u.getPassword().equals(password) ) ? u : null ;
		
		// 校验 从数据查询得到的用户 的密码  是否和 password 一致
		// 是返回 用户信息 ，否则放回 null
		if( u != null && u.getPassword().equals(password) ){
			return u ;
		}
		return null ;
	}

	/**
	 * 添加用户
	 */
	@Override
	public User add(User user) {
		// 设置 id
		user.setId( UUIDUtil.getUUID() );
		// 设置 添加入职时间
		Date date = new Date() ;
		String workDate = DateFormat.getDateInstance().format(date) ;
		user.setWorkdate( workDate );
		userDao.add(user);
		
		// 返回 新增加的 用户信息
		return checkUser(user.getUsername(),user.getPassword());
	}
	
	/**
	 * 通过用户id ，查找用户
	 */
	@Override
	public User findUserById(String userId) {
		return userDao.findUserById(userId);
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public User update(User user) {
		userDao.update(user);
		
		// 返回 新增加的 用户信息
		return checkUser(user.getUsername(),user.getPassword());
	}

	/**
	 * (分页查找)
	 * 查找出所有用户
	 */
	@Override
	public Page findPage(String role,int page , int rows) {
		
        // 符合条件的总条数
        int totalNum = userDao.findAllCount( role ) ;
        // 当前页的起始下标
        int startIndex = page * rows ;
        
        System.out.println( "开始下标 ： " + startIndex ); // 没错

        // 得到 查询得到 List<User>
        List<User> users =  userDao.findPage( role , startIndex, rows);
        System.out.println( "查询到的信息条数 ： " + users.size() ); // 返回的数目不对
        
        // 总页数
        int totalPage =  totalNum % rows > 0 ? totalNum/rows + 1 : totalNum/rows ;

        // 返回封装好的结果 Page
        return new Page( users , totalNum , totalPage , page ) ;
	}

	/**
	 * 通过 ids 批量删除 
	 */
	@Override
	public boolean delete(String[] ids) {
		// 遍历 ids 逐个删除
		for( String id : ids ){
			userDao.deleteByIds(id);
		}
		// 遍历 ids 逐个查找，如果还能找得到，证明删除不成功
		for( String id : ids ){
			return userDao.findUserById(id) != null ? false : true ;
		}
		return true;
	}

	/**
	 * 通过用户名查找用户
	 */
	@Override
	public User findUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

	/**
	 * 查找出所有用户
	 */
	/*@Override
	public List<User> findAll(String role) {
		return userDao.findAll(role);
	}*/

}
