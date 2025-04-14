package com.expense.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.expenses.entity.ExpenseBook;

public interface ExpenseBookRepository extends JpaRepository<ExpenseBook,Long> {
	
}
