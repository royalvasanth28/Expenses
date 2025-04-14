package com.expense.expenses.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "expense_user")
public class ExpenseUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "expense_id")
	private ExpenseBook expenseBook;
	
	@ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
	
	private BigDecimal amount;
	@Column(name = "created_at",columnDefinition = "DATETIME")
	private LocalDateTime createdAt;
	@Column(name = "updated_at",columnDefinition = "DATETIME")
	private LocalDateTime updatedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ExpenseBook getExpenseBook() {
		return expenseBook;
	}
	public void setExpenseBook(ExpenseBook expenseBook) {
		this.expenseBook = expenseBook;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
	
	
}
