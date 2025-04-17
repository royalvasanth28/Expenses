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
import com.expense.expenses.entity.Categories;
import com.expense.expenses.service.CategoriesService;

@RequestMapping("/expense/categories")
@RestController
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Categories>> saveCategories(@RequestBody Categories categories){
		return categoriesService.saveCategories(categories);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Categories>> getCategoriesById(@PathVariable Long id){
		return categoriesService.getCategoriesById(id);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Categories>>> getAllCategories(){
		return categoriesService.getAllCategories();
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Categories>> updateCategories(@RequestBody Categories categories){
		return categoriesService.updateCategories(categories);
	}
	@DeleteMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Categories>> deleteCategories(@PathVariable Long id){
		return categoriesService.deleteCategories(id);
	}
}
