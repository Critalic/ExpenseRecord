package com.example.expenserecord.repository;

import com.example.expenserecord.model.Category;
import com.example.expenserecord.model.Customer;
import com.example.expenserecord.model.Record;

import java.util.List;

public interface ExpenseRepository {

    Customer addCustomer(Customer customer);

    Record addRecord(Record record);

    Category addCategory(Category category);

    List<Record> getRecords();

    List<Customer> getCustomers();

    List<Category> getCategories();
}
