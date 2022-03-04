/**
 * 
 */
package com.programming.techie.mongo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.programming.techie.mongo.model.Expense;
import com.programming.techie.mongo.repository.ExpenseRepository;

/**
 * @author anees
 *
 */
@Service
public class ExpenseService {
	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseService.class);
	
	private final ExpenseRepository expenseReporsitory;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseReporsitory = expenseRepository;
	}
	
	
	public void addExpense(Expense expense) {
		logger.info("--------------------Inside AddExpense methos in Expense Service---------------------");
		expenseReporsitory.insert(expense);
		logger.info("--------------------Ending AddExpense methos in Expense Service---------------------");
	}
	
	public void updateExpense(Expense expense) {
		Expense savedExpense = expenseReporsitory.findById(expense.getId())
				.orElseThrow(() -> new RuntimeException(String.format("Cannot find expense by id %s", expense.getId())));
		
		savedExpense.setExpenseName(expense.getExpenseName());
		savedExpense.setExpenseCategory(expense.getExpenseCategory());
		savedExpense.setExpenseAmount(expense.getExpenseAmount());
		
		expenseReporsitory.save(expense);
	}
	
	public List<Expense> getAllExpense() {
		return expenseReporsitory.findAll();
	}
	
	public Optional<Expense> getExpenseByName(String name) {
		return expenseReporsitory.findByName(name);
//				.orElseThrow(() -> new RuntimeException(String.format("Cannot find expense by name %s", name)));
	}
	
	public void deleteExpense(String id) {
		expenseReporsitory.deleteById(id);
	}
}
