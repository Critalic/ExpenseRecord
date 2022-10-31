package com.example.expenserecord.repository.mongo;

import com.example.expenserecord.model.Record;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecordRepository extends MongoRepository<Record, String> {
    List<Record> findByCustomerId(String customerId);

    List<Record> findByCategoryIdAndCustomerId(String categoryId, String customerId);
}
