package com.example.expenserecord.repository.implementation;

import com.example.expenserecord.model.Category;
import com.example.expenserecord.model.Customer;
import com.example.expenserecord.model.Record;
import com.example.expenserecord.repository.ExpenseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Repository("inMemory")
public class ExpenseRepositoryInMemory implements ExpenseRepository {
    private final HashSet<Record> records = new HashSet<>();
    private final HashSet<Customer> customers = new HashSet<>();
    private final HashSet<Category> categories = new HashSet<>();

    public synchronized Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public synchronized Record addRecord(Record record) {
        records.add(record);
        return record;
    }

    public synchronized Category addCategory(Category category) {
        categories.add(category);
        return category;
    }

    public List<Record> getRecords() {
        return new ArrayList<>(records);
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }
}
