package com.expense.expenses.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.expense.expenses.entity.ExpenseBook;
import com.expense.expenses.repository.ExpenseBookRepository;

@Repository
public class ExpenseBookDao {

	@Autowired
	private ExpenseBookRepository expenseBookRepository;
	
	public ExpenseBook saveExpenseBook(ExpenseBook expenseBook)
	{
		expenseBookRepository.save(expenseBook);
		return expenseBook;
	}
	
	public ExpenseBook getExpenseBookById(long id) {
		Optional<ExpenseBook> optional=expenseBookRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public List<ExpenseBook> getAllExpenseBook() {
		return expenseBookRepository.findAll();
	}
	
	public ExpenseBook updateExpenceBook(ExpenseBook expenseBook) {
		Optional<ExpenseBook> optional=expenseBookRepository.findById(expenseBook.getId());
		if(optional.isPresent()) {
			ExpenseBook existingExpenseBook=optional.get();
			
			existingExpenseBook.setBookName(expenseBook.getBookName());
			existingExpenseBook.setUpdatedAt(expenseBook.getUpdatedAt());
			existingExpenseBook.setDeletedAt(expenseBook.getDeletedAt());
			
			return expenseBookRepository.save(existingExpenseBook);
		}else {
			return null;
		}
	}

	public ExpenseBook deleteExpenseBook(long id) {
		Optional<ExpenseBook> optional=expenseBookRepository.findById(id);
		if(optional.isPresent()) {
			expenseBookRepository.delete(optional.get());
			return optional.get();
		}else {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
