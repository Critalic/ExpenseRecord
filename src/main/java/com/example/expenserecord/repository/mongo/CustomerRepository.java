package com.example.expenserecord.repository.mongo;

import com.example.expenserecord.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByName(Object unknownAttr1);

    boolean existsByName(Object unknownAttr1);
}
