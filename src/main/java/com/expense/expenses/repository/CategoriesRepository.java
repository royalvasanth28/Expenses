package com.expense.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.expenses.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories,Long> {

}
