package com.library.service;

import java.util.List;

import com.library.domian.Book;



public interface BookService {
	
	public List<Book> listAllBook();
	public void editBook(Book book);
	public Book findBookById(String id);
	public void deleteBook(String id);
	public void addBook(Book book);
}
