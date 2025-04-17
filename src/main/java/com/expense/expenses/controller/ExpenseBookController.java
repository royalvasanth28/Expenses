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
import com.expense.expenses.entity.ExpenseBook;
import com.expense.expenses.service.ExpenseBookService;

@RestController
@RequestMapping("/expense/expensebook")
public class ExpenseBookController {
	
	@Autowired
	private ExpenseBookService expenseBookService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<ExpenseBook>> saveExpenseBook(@RequestBody ExpenseBook expenseBook){
		return expenseBookService.saveExpenseBook(expenseBook);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<ExpenseBook>> getExpenseBookById(@PathVariable Long id){
		return expenseBookService.getExpenseBookById(id);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<ExpenseBook>>> getAllExpenseBook(){
		return expenseBookService.getAllExpenseBook();
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<ExpenseBook>> updateExpenseBook(@RequestBody ExpenseBook expenseBook){
		return expenseBookService.updateExpenseBook(expenseBook);
	}
	@DeleteMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<ExpenseBook>> deleteExpenseBook(@PathVariable Long id){
		return expenseBookService.deleteExpenseBook(id);
	}
}
