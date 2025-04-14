package com.expense.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.expenses.entity.ExpenseUser;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser,Long>{
	
}
