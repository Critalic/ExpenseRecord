package com.example.expenserecord.service;

import com.example.expenserecord.model.Category;
import com.example.expenserecord.model.Customer;
import com.example.expenserecord.model.MonetaryUnit;
import com.example.expenserecord.model.Record;
import com.example.expenserecord.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseService(@Qualifier("mongoDB") ExpenseRepository repository) {
        this.repository = repository;
    }

    public Customer addCustomer(Customer customer) {
        return repository.addCustomer(customer);
    }

    public Record addRecord(Record record) {
        verifyRecordUserAndCategory(record);
        return repository.addRecord(record);
    }

    public Category addCategory(Category category) {
        return repository.addCategory(category);
    }

    public List<Category> getCategories() {
        return repository.getCategories();
    }

    public List<Record> getRecordsForCustomer(Long userId) {
        return repository.getRecords().stream()
                .filter(record -> record.getCustomerId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<Record> getCategoricalRecordsForCustomer(Long userId, Long categoryId) {
        return repository.getRecords().stream()
                .filter(record -> record.getCustomerId().equals(userId))
                .filter(record -> record.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }


    private void verifyRecordUserAndCategory(Record record) {
        if (repository.getCategories().stream()
                .noneMatch(category -> category.getId().equals(record.getCategoryId()))) {
            throw new ValidationException("Given record's category doesn't exist");
        }

        if (repository.getCustomers().stream()
                .noneMatch(customer -> customer.getId().equals(record.getCustomerId()))) {
            throw new ValidationException("Given record's customer doesn't exist");
        }
    }

    public MonetaryUnit addMonetaryUnit(MonetaryUnit monetaryUnit) {
        return repository.addMonetaryUnit(monetaryUnit);
    }

    public List<MonetaryUnit> getMonetaryUnits() {
        return repository.getMonetaryUnits();
    }
}
