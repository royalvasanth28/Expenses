package com.expense.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.expenses.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
