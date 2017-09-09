package com.library.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import com.library.dao.BorrowDao;
import com.library.domian.Borrow;
import com.library.utils.C3P0Util;



public class BorrowDaoImpl implements BorrowDao{

	public List<Borrow> findAllBorrow() {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		
		List<Borrow> borrows=null;
		try {
			 borrows=qr.query("SELECT * FROM borrow;", new BeanListHandler<Borrow>(Borrow.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borrows;
	}

	public void updateBorrow(Borrow borrow) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			qr.update("UPDATE borrow SET isbn=?,number=?,state=? WHERE userId=? ",borrow.getIsbn(),borrow.getNumber(),borrow.getState(),borrow.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Borrow infoBorrowById(String id) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Borrow borrow=null;
		try {
			borrow=qr.query("SELECT * FROM borrow WHERE id=?", new BeanHandler<Borrow>(Borrow.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borrow;
	}



}
