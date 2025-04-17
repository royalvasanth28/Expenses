package com.expense.expenses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expenses.dto.ResponseStructure;
import com.expense.expenses.entity.ExpenseUser;
import com.expense.expenses.service.ExpenseUserService;

@RestController
@RequestMapping("/expense/expenseUser")
public class ExpenseUserController {
	
	@Autowired
	private ExpenseUserService expenseUserService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<ExpenseUser>> addExpenseUser(@RequestBody ExpenseUser expenseUser){
		return expenseUserService.addExpenseUser(expenseUser);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<ExpenseUser>> getExpenseUserById(@PathVariable Long id){
		return expenseUserService.getExpenseUserById(id);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<ExpenseUser>>> getAllExpenseUser(){
		return expenseUserService.getAllExpenseUser();
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<ExpenseUser>> updateExpenseUser(@RequestBody ExpenseUser expenseUser){
		return expenseUserService.updateExpenseUser(expenseUser);
	}
	@DeleteMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<ExpenseUser>> deleteExpenseUser(@PathVariable Long id){
		return expenseUserService.deleteExpenseUser(id);
	}
}
