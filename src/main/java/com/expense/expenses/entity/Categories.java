package com.expense.expenses.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "category_name")
	private String categoryName;
	private String description;
	@Column(name = "created_at",columnDefinition = "DATETIME")
	private LocalDateTime  createdAt;
	@Column(name = "updated_at",columnDefinition = "DATETIME")
	private LocalDateTime  updatedAt;
	@Column(name = "deleted_at",columnDefinition = "DATETIME")
	private LocalDateTime  deletedAt;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	@JsonBackReference
	private ExpenseBook expenseBook;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	public ExpenseBook getExpenseBook() {
		return expenseBook;
	}

	public void setExpenseBook(ExpenseBook expenseBook) {
		this.expenseBook = expenseBook;
	}
	
	
	
}
