package com.expense.expenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.expense.expenses.dao.ExpenseUserDao;
import com.expense.expenses.dto.ResponseStructure;
import com.expense.expenses.entity.ExpenseUser;
import com.expense.expenses.exception.IdNotFoundException;
import com.expense.expenses.exception.ResourceNotFoundException;

@Service
public class ExpenseUserService {
		
	@Autowired
	private ExpenseUserDao expenseUserDao;
	
	public ResponseEntity<ResponseStructure<ExpenseUser>> addExpenseUser(ExpenseUser expenseUser){
		ExpenseUser	recieveexpenseUser=expenseUserDao.addExpenseUser(expenseUser);
		ResponseStructure<ExpenseUser> structure=new ResponseStructure<ExpenseUser>();
		
		structure.setStatus(true);
		structure.setMessage("ExpenseUser saved successfully");
		structure.setData(recieveexpenseUser);
		return new ResponseEntity<ResponseStructure<ExpenseUser>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<ExpenseUser>> getExpenseUserById(long id){
		ExpenseUser expenseUser=expenseUserDao.getExpenseUserById(id);
		ResponseStructure<ExpenseUser> structure = new ResponseStructure<ExpenseUser>();
		if(expenseUser!=null) {
			structure.setStatus(true);
			structure.setMessage("Data retrieved successfully");
			structure.setData(expenseUser);
			
			return new ResponseEntity<ResponseStructure<ExpenseUser>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<ExpenseUser>>> getAllExpenseUser(){
		List<ExpenseUser> expenseUsers=expenseUserDao.getAllExpenseUser();
		ResponseStructure<List<ExpenseUser>> structure = new ResponseStructure<List<ExpenseUser>>();
		
		if(expenseUsers.size()>0) {
			structure.setStatus(true);
			structure.setMessage("Data's retrieved successfully");
			structure.setData(expenseUsers);
			return new ResponseEntity<ResponseStructure<List<ExpenseUser>>>(structure,HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<ExpenseUser>> updateExpenseUser(ExpenseUser expenseUser){
		ExpenseUser user=expenseUserDao.updateExpenseUser(expenseUser);
		ResponseStructure<ExpenseUser> structure = new ResponseStructure<ExpenseUser>();
		if(user!=null) {
			structure.setStatus(true);
			structure.setMessage("ExpenseUser updated successfully");
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<ExpenseUser>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<ExpenseUser>> deleteExpenseUser(long id){
		ExpenseUser expenseUser=expenseUserDao.deleteExpenseUser(id);
		ResponseStructure<ExpenseUser> structure = new ResponseStructure<ExpenseUser>();
		
		if(structure!=null) {
			structure.setStatus(true);
			structure.setMessage("ExpenseUser Deleted successfully");
			structure.setData(expenseUser);
			return new ResponseEntity<ResponseStructure<ExpenseUser>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
