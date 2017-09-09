package com.library.dao;

import java.util.List;

import com.library.domian.User;


/**
 * 
 * @ClassName UserDao
 * @Description user Dao 接口
 * @author 黄洁芳
 * @date 2017年6月18日
 */
public interface UserDao {

	User findByUsername(String username);

	List<User> findAll(String userRole);

	void add(User user);

	User findUserById(String userId);

	void update(User user);

	List<User> findPage(String role, int startIndex, int endIndex);

	int findAllCount(String role);

	void deleteByIds(String id);

}
