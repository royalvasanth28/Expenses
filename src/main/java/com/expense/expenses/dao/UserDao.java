package com.expense.expenses.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.expense.expenses.entity.User;
import com.expense.expenses.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		userRepository.save(user);
		return user;
	}
	
	public User getUserById(long id) {
		Optional<User> user=userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User updateUser(User user) {
		Optional<User> optional = userRepository.findById(user.getId());
	    if (optional.isPresent()) {
	        User existingUser = optional.get();

	        existingUser.setUserName(user.getUserName());
	        existingUser.setPassword(user.getPassword());
	        existingUser.setPhoneNumber(user.getPhoneNumber());
	        existingUser.setGmail(user.getGmail());

	        return userRepository.save(existingUser);
	    } else {
	        return null;
	    }
	}
	
	public User deleteUser(long id) {
		Optional<User> optional=userRepository.findById(id);
		if(optional.isPresent()) {
			userRepository.delete(optional.get());
			return optional.get();
		}else {
			return null;
		}
		
	}
	
}
