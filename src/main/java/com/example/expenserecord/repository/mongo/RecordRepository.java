package com.example.expenserecord.repository.mongo;

import com.example.expenserecord.model.Customer;
import com.example.expenserecord.model.Record;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecordRepository extends MongoRepository<Record, Long> {
}
