package com.expense.expenses.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.expense.expenses.entity.Categories;
import com.expense.expenses.repository.CategoriesRepository;

@Repository
public class CategoriesDao {
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	public Categories saveCategories(Categories categories) {
		categoriesRepository.save(categories);
		return categories;
	}
	
	public Categories getCategoriesById(long id) {
		Optional<Categories> optional=categoriesRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public List<Categories> getAllCategories(){
		return categoriesRepository.findAll();
	}
	public Categories updateCategories(Categories categories) {
		Optional<Categories> optional=categoriesRepository.findById(categories.getId());
		if(optional.isPresent()) {
			Categories existingCategories=optional.get();
			existingCategories.setCategoryName(categories.getCategoryName());
			existingCategories.setDescription(categories.getDescription());
			existingCategories.setUpdatedAt(categories.getUpdatedAt());
			existingCategories.setDeletedAt(categories.getDeletedAt());
			
			return categoriesRepository.save(existingCategories);
		}else {
			return null;
		}
	}
	
	public Categories deleteCategories(long id) {
		Optional<Categories> optional=categoriesRepository.findById(id);
		if(optional.isPresent()) {
			categoriesRepository.delete(optional.get());
			return optional.get();
		}else {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
