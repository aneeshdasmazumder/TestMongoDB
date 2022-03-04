/**
 * 
 */
package com.programming.techie.mongo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;
import com.programming.techie.mongo.model.Expense;
import com.programming.techie.mongo.service.ExpenseService;

/**
 * @author anees
 *
 */
@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);
	
	private final ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@PostMapping
	public ResponseEntity<Object> addExpense(@RequestBody Expense expense) {
		logger.info("-------------Inside Post Method---------------");
		logger.info("Expense: "+expense);
		expenseService.addExpense(expense);
		logger.info("----------------------------------");
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> updateExpense(@RequestBody Expense expense) {
		expenseService.updateExpense(expense);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Expense>> getAllExpense() {
		return ResponseEntity.ok(expenseService.getAllExpense());
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Optional<Expense>> getExpenseByName(@PathVariable String name) {
		return ResponseEntity.ok(expenseService.getExpenseByName(name));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteExpense(@PathVariable String id) {
		expenseService.deleteExpense(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
