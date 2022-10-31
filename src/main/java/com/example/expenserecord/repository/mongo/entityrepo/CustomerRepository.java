package com.example.expenserecord.repository.mongo.entityrepo;

import com.example.expenserecord.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
