/**
 * 
 */
package com.programming.techie.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.google.common.base.Optional;
import com.programming.techie.mongo.model.Expense;

/**
 * @author anees
 *
 */
public interface ExpenseRepository extends MongoRepository<Expense, String>  {
	@Query("{'name': ?0}")	
	Optional<Expense> findByName(String name);
}
