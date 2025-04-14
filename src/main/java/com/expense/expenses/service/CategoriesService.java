package com.expense.expenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.expense.expenses.dao.CategoriesDao;
import com.expense.expenses.dto.ResponseStructure;
import com.expense.expenses.entity.Categories;
import com.expense.expenses.exception.IdNotFoundException;
import com.expense.expenses.exception.ResourceNotFoundException;

@Service
public class CategoriesService {

	@Autowired
	private CategoriesDao categoriesDao;
	
	public ResponseEntity<ResponseStructure<Categories>> saveCategories(Categories categories){
		Categories reciveCategories=categoriesDao.saveCategories(categories);
		ResponseStructure<Categories> structure = new ResponseStructure<Categories>();
		structure.setStatus(true);
		structure.setMessage("Category saved successfully");
		structure.setData(reciveCategories);
		
		return new ResponseEntity<ResponseStructure<Categories>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Categories>> getCategoriesById(long id){
		Categories categories=categoriesDao.getCategoriesById(id);
		ResponseStructure<Categories> structure = new ResponseStructure<Categories>();
		if(categories!=null) {
			structure.setStatus(true);
			structure.setMessage("Categories found Successfully");
			structure.setData(categories);
			return new ResponseEntity<ResponseStructure<Categories>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Categories>>> getAllCategories(){
		List<Categories> categories =categoriesDao.getAllCategories();
		ResponseStructure<List<Categories>> structure = new ResponseStructure<List<Categories>>();
		if(categories.size()>0) {
			structure.setStatus(true);
			structure.setMessage("All categories fetched successfully");
			structure.setData(categories);
			
			return new ResponseEntity<ResponseStructure<List<Categories>>>(structure,HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Categories>> updateCategories(Categories categories){
		Categories updatedCategories=categoriesDao.updateCategories(categories);
		ResponseStructure<Categories> structure = new ResponseStructure<Categories>();
		if(updatedCategories!=null) {
			structure.setStatus(true);
			structure.setMessage("Categories Update Successfully");
			structure.setData(updatedCategories);
			return new ResponseEntity<ResponseStructure<Categories>>(structure,HttpStatus.CREATED);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Categories>> deleteCategories(long id){
		Categories categories=categoriesDao.deleteCategories(id);
		ResponseStructure<Categories> structure = new ResponseStructure<Categories>();
		if(categories!=null) {
			structure.setStatus(true);
			structure.setMessage("Category deleted successfully");
			structure.setData(categories);
			
			return new ResponseEntity<ResponseStructure<Categories>>(structure,HttpStatus.OK);
		}else{
			throw new IdNotFoundException();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
