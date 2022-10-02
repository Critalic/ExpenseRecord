package com.example.expenserecord.repository;

import com.example.expenserecord.model.Category;
import com.example.expenserecord.model.Customer;
import com.example.expenserecord.model.Record;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public class ExpenseRepository {
    private final HashSet<Record> records = new HashSet<>();
    private final HashSet<Customer> customers = new HashSet<>();
    private final HashSet<Category> categories = new HashSet<>();

    public synchronized void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public synchronized void addRecord(Record record) {
        records.add(record);
    }

    public synchronized void addCategory(Category category) {
        categories.add(category);
    }

    public HashSet<Record> getRecords() {
        return new HashSet<>(records);
    }

    public HashSet<Customer> getCustomers() {
        return new HashSet<>(customers);
    }

    public HashSet<Category> getCategories() {
        return new HashSet<>(categories);
    }
}
