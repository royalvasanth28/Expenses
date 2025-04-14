package com.expense.expenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.expense.expenses.dao.ExpenseBookDao;
import com.expense.expenses.dto.ResponseStructure;
import com.expense.expenses.entity.ExpenseBook;
import com.expense.expenses.exception.IdNotFoundException;
import com.expense.expenses.exception.ResourceNotFoundException;

@Service
public class ExpenseBookService {
	
	@Autowired
	private ExpenseBookDao expenseBookDao;
	
	public ResponseEntity<ResponseStructure<ExpenseBook>> saveExpenseBook(ExpenseBook expenseBook){
		ExpenseBook recieveExpenseBook=expenseBookDao.saveExpenseBook(expenseBook);
		ResponseStructure<ExpenseBook> structure= new ResponseStructure<ExpenseBook>();
		
		structure.setStatus(true);
		structure.setMessage("User saved successfully");
		structure.setData(recieveExpenseBook);
		
		return new ResponseEntity<ResponseStructure<ExpenseBook>>(structure,HttpStatus.CREATED);
	
	}
	
	public ResponseEntity<ResponseStructure<ExpenseBook>> getExpenseBookById(long id){
		ExpenseBook expenseBook=expenseBookDao.getExpenseBookById(id);
		ResponseStructure<ExpenseBook> structure = new ResponseStructure<ExpenseBook>();
		if(expenseBook!=null) {
			structure.setStatus(true);
			structure.setMessage("ExpenseBook found successfully");
			structure.setData(expenseBook);
			
			return new ResponseEntity<ResponseStructure<ExpenseBook>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<ExpenseBook>>> getAllExpenseBook(){
		List<ExpenseBook> expenseBooks=expenseBookDao.getAllExpenseBook();
		ResponseStructure<List<ExpenseBook>> structure = new ResponseStructure<List<ExpenseBook>>();
		if(expenseBooks.size()>0) {
			structure.setStatus(true);
			structure.setMessage("ExpenseBooks found successfully");
			structure.setData(expenseBooks);
			
			return new ResponseEntity<ResponseStructure<List<ExpenseBook>>>(structure,HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<ExpenseBook>> updateExpenseBook(ExpenseBook expenseBook){
		ExpenseBook book=expenseBookDao.updateExpenceBook(expenseBook);
		ResponseStructure<ExpenseBook> structure = new ResponseStructure<ExpenseBook>();
		
		if(book!=null) {
			structure.setStatus(true);
			structure.setMessage("ExpenseBook updated successfully");
			structure.setData(book);
			return new ResponseEntity<ResponseStructure<ExpenseBook>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<ExpenseBook>> deleteExpenseBook(long id){
		ExpenseBook book=expenseBookDao.deleteExpenseBook(id);
		if(book!=null) {
			ResponseStructure<ExpenseBook> structure=new ResponseStructure<ExpenseBook>();
			structure.setStatus(true);
			structure.setMessage("ExpenseUser deleted successfully");
			structure.setData(null);
			
			return new ResponseEntity<ResponseStructure<ExpenseBook>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
