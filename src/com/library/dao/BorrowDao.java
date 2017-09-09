package com.library.dao;

import java.util.List;

import com.library.domian.Borrow;

public interface BorrowDao {

	List<Borrow> findAllBorrow();

	void updateBorrow(Borrow borrow);

	Borrow infoBorrowById(String id);

	

	
}
