package com.library.domian;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description user 实体类
 * @author 黄洁芳
 * @date 2017年6月18日
 */
public class User implements Serializable {
	
	/**
	 * 主键id
	 */
	private String id;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 工作编号
	 */
	private int workNumber;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 工作时间
	 */
	private String workdate;
	
	/**
	 * 角色 sysAdmin 系统管理员, libAdmin 图书管理员 , borrower 借阅者
	 */
	private String role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWorkNumber() {
		return workNumber;
	}
	public void setWorkNumber(int workNumber) {
		this.workNumber = workNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getWorkdate() {
		return workdate;
	}
	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", name=" + name + ", workNumber=" + workNumber
				+ ", sex=" + sex + ", workdate=" + workdate + ", role=" + role
				+ "]";
	}
	
	
	
}
