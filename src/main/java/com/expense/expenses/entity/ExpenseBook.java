package com.expense.expenses.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "expense_book")
public class ExpenseBook {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "created_at",columnDefinition = "DATETIME")
	private LocalDateTime createdAt;
	@Column(name = "updated_at",columnDefinition = "DATETIME")
	private LocalDateTime updatedAt;
	@Column(name = "deleted_at",columnDefinition = "DATETIME")
	private LocalDateTime deletedAt;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "expenseBook", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Categories> categories;
	
	@OneToMany(mappedBy = "expenseBook",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ExpenseUser> expenseUsers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	public List<ExpenseUser> getExpenseUsers() {
		return expenseUsers;
	}

	public void setExpenseUsers(List<ExpenseUser> expenseUsers) {
		this.expenseUsers = expenseUsers;
	}
	
	
	
}
