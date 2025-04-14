package com.expense.expenses.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.expense.expenses.entity.ExpenseUser;
import com.expense.expenses.repository.ExpenseUserRepository;

@Repository
public class ExpenseUserDao {
	
	@Autowired
	private ExpenseUserRepository expenseUserRepository;
	
	public ExpenseUser addExpenseUser(ExpenseUser expenseUser) {
		expenseUserRepository.save(expenseUser);
		return expenseUser;
	}
	
	public ExpenseUser getExpenseUserById(long id) {
		Optional<ExpenseUser> optional=expenseUserRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public List<ExpenseUser> getAllExpenseUser(){
		return expenseUserRepository.findAll();
	}
	
	public ExpenseUser updateExpenseUser(ExpenseUser expenseUser) {
		Optional<ExpenseUser> optional = expenseUserRepository.findById(expenseUser.getId());
		if(optional.isPresent()) {
			ExpenseUser existingexpenseUser=optional.get();
			existingexpenseUser.setExpenseBook(expenseUser.getExpenseBook());
			existingexpenseUser.setUser(expenseUser.getUser());
			existingexpenseUser.setAmount(expenseUser.getAmount());
			existingexpenseUser.setUpdatedAt(expenseUser.getUpdatedAt());
			
			return expenseUserRepository.save(existingexpenseUser);
		}else {
			return null;
		}
	}
	
	public ExpenseUser deleteExpenseUser(long id) {
		Optional<ExpenseUser> optional= expenseUserRepository.findById(id);
		if(optional.isPresent()) {
			expenseUserRepository.delete(optional.get());
			return optional.get();
		}else {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
