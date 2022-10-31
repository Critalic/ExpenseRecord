package com.example.expenserecord.repository.mongo;

import com.example.expenserecord.model.MonetaryUnit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MonetaryUnitRepository extends MongoRepository<MonetaryUnit, Long> {
}
