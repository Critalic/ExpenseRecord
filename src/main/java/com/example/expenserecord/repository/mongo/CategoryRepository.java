package com.example.expenserecord.repository.mongo;

import com.example.expenserecord.model.Category;
import com.example.expenserecord.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
