package com.library.service;

import java.util.List;

import com.library.domian.Borrow;



public interface BorrowService {
	
	public List<Borrow> listAllBorrow();
	public void editBorrow(Borrow borrow);


	public Borrow findBorrowById(String id);
}
