package com.programming.techie.mongo.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Expense")
public class Expense {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	@Field(name="name")
	private String expenseName;
	
	@Field(name="category")
	private ExpenseCategory expenseCategory;
	
	@Field(name="amount")
	private BigDecimal expenseAmount;
	
	
	/**
	 * @param id
	 * @param expenseName
	 * @param expenseCategory
	 * @param expenseAmount
	 */
	public Expense(String id, String expenseName, ExpenseCategory expenseCategory, BigDecimal expenseAmount) {
		super();
		this.id = id;
		this.expenseName = expenseName;
		this.expenseCategory = expenseCategory;
		this.expenseAmount = expenseAmount;
	}
	
	public Expense() {}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the expenseName
	 */
	public String getExpenseName() {
		return expenseName;
	}
	/**
	 * @param expenseName the expenseName to set
	 */
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	/**
	 * @return the expenseCategory
	 */
	public ExpenseCategory getExpenseCategory() {
		return expenseCategory;
	}
	/**
	 * @param expenseCategory the expenseCategory to set
	 */
	public void setExpenseCategory(ExpenseCategory expenseCategory) {
		this.expenseCategory = expenseCategory;
	}
	/**
	 * @return the expenseAmount
	 */
	public BigDecimal getExpenseAmount() {
		return expenseAmount;
	}
	/**
	 * @param expenseAmount the expenseAmount to set
	 */
	public void setExpenseAmount(BigDecimal expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", expenseName=" + expenseName + ", expenseCategory=" + expenseCategory
				+ ", expenseAmount=" + expenseAmount + "]";
	}
	
	
}
