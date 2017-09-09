package com.library.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import com.library.dao.BookDao;
import com.library.domian.Book;
import com.library.utils.C3P0Util;



public class BookDaoImpl implements BookDao{

	public List<Book> findAllBook() {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		List<Book> books=null;
		try {
			 books=qr.query("SELECT * FROM book;", new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public void updateBook(Book book) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			qr.update("UPDATE book SET bookname=?,publication=?,pubdate=?,price=?,number=? WHERE id=?",book.getBookname(),book.getPublication(),book.getPubdate(),book.getPrice(),book.getNumber(),book.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Book infoBookById(String id) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Book book=null;
		try {
			book=qr.query("SELECT * FROM book WHERE id=?", new BeanHandler<Book>(Book.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	public void deleteBook(String id) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			qr.update("DELETE  FROM book WHERE id=?",id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addBook(Book book) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			qr.update("INSERT INTO book VALUES(?,?,?,?,?,?)",book.getId(),book.getBookname(),book.getPublication(),book.getPubdate(),book.getPrice(),book.getNumber());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
