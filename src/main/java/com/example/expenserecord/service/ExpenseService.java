package com.example.expenserecord.service;

import com.example.expenserecord.model.Category;
import com.example.expenserecord.model.Customer;
import com.example.expenserecord.model.Record;
import com.example.expenserecord.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public void addCustomer(Customer customer) {
        repository.addCustomer(customer);
    }

    public void addRecord(Record record) {
        verifyRecordUserAndCategory(record);
        repository.addRecord(record);
    }

    public void addCategory(Category category) {
        repository.addCategory(category);
    }

    public Set<Category> getCategories() {
        return repository.getCategories();
    }

    public Set<Record> getRecordsForCustomer(Long userId) {
        return repository.getRecords().stream()
                .filter(record -> record.getUserId().equals(userId))
                .collect(Collectors.toSet());
    }

    public Set<Record> getCategoricalRecordsForCustomer(Long userId, Long categoryId) {
        return repository.getRecords().stream()
                .filter(record -> record.getUserId().equals(userId))
                .filter(record -> record.getCategoryId().equals(categoryId))
                .collect(Collectors.toSet());
    }


    private void verifyRecordUserAndCategory(Record record) {
        if(repository.getCategories().stream()
                .noneMatch(category -> category.getId().equals(record.getCategoryId()))) {
            throw new ValidationException("Given record's category doesn't exist");
        }

        if(repository.getCustomers().stream()
                .noneMatch(customer -> customer.getId().equals(record.getUserId()))) {
            throw new ValidationException("Given record's customer doesn't exist");
        }
    }
}
