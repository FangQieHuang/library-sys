package com.library.dao;

import java.util.List;

import com.library.domian.Book;

public interface BookDao {

	List<Book> findAllBook();

	void updateBook(Book book);

	Book infoBookById(String id);

	void deleteBook(String id);

	void addBook(Book book);

	
}
