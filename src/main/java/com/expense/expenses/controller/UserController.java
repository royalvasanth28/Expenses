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
import com.expense.expenses.entity.User;
import com.expense.expenses.service.UserService;

@RequestMapping("/expense/user")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> addUser(@RequestBody User user){
		return userService.addUser(user);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> getUserById(@PathVariable long id){
		return userService.getUserById(id);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<User>>> getAllUsers(){
		return userService.getAllUsers();
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}
	@DeleteMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@PathVariable long id){
		return userService.deleteUser(id);
	}
}















