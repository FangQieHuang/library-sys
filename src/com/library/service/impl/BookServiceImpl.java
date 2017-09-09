package com.library.service.impl;

import java.util.List;

import com.library.dao.BookDao;
import com.library.dao.impl.BookDaoImpl;
import com.library.domian.Book;

import com.library.service.BookService;

public class BookServiceImpl implements BookService{

	BookDao bookDao=new BookDaoImpl();
	
	public List<Book> listAllBook() {
		return bookDao.findAllBook();
	}

	public Book findBookById(String id) {
		return bookDao.infoBookById(id);
	}

	public void deleteBook(String id) {
		bookDao.deleteBook(id);
	}

	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	public void editBook(Book book) {
		bookDao.updateBook(book);
	}
}
