package com.library.service.impl;

import java.util.List;

import com.library.dao.BorrowDao;
import com.library.dao.impl.BorrowDaoImpl;
import com.library.domian.Borrow;

import com.library.service.BorrowService;

public class BorrowServiceImpl implements BorrowService{

	
	BorrowDao borrowDao=new BorrowDaoImpl();
	
	public List<Borrow> listAllBorrow() {
		return borrowDao.findAllBorrow();
	}

	public Borrow findBorrowById(String id) {
		return borrowDao.infoBorrowById(id);
	}


	public void editBorrow(Borrow borrow) {
		borrowDao.updateBorrow(borrow);
	}

	


}
