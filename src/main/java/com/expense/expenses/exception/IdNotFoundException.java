package com.expense.expenses.exception;

public class IdNotFoundException extends RuntimeException {
	
	@Override
	public String getMessage()
	{
		return "Id not found in the database";
	}
}
