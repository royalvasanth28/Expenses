package com.expense.expenses.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.expense.expenses.dao.UserDao;
import com.expense.expenses.dto.ResponseStructure;
import com.expense.expenses.entity.User;
import com.expense.expenses.exception.IdNotFoundException;
import com.expense.expenses.exception.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<ResponseStructure<User>> addUser(User user){
		User recieveuser=userDao.addUser(user);
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		
		responseStructure.setStatus(true);
		responseStructure.setMessage("User added successfully");
		responseStructure.setData(recieveuser);
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<User>> getUserById(long id){
		User user=userDao.getUserById(id);
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		
		if(user!=null) {
			responseStructure.setStatus(true);
			responseStructure.setMessage("User retrieved successfully");
			responseStructure.setData(user);
			
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> getAllUsers(){
		List<User> users=userDao.getAllUsers();
		ResponseStructure<List<User>> responseStructure= new ResponseStructure<List<User>>();
		
		if(users.size()>0) {
			responseStructure.setStatus(true);
			responseStructure.setMessage("User retrieved successfully");
			responseStructure.setData(users);
			
			return new ResponseEntity<ResponseStructure<List<User>>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new ResourceNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User user){
		User updateUser=userDao.updateUser(user);
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		
		if(updateUser!=null) {
			responseStructure.setStatus(true);
			responseStructure.setMessage("User updated successfully");
			responseStructure.setData(updateUser);
			
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUser(long id){
		User user=userDao.deleteUser(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		
		if(user!=null) {
			responseStructure.setStatus(true);
			responseStructure.setMessage("User deleted successfully");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
}
