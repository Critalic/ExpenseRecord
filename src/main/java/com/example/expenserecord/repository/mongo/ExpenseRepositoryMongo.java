package com.example.expenserecord.repository.mongo;

import com.example.expenserecord.model.Category;
import com.example.expenserecord.model.Customer;
import com.example.expenserecord.model.MonetaryUnit;
import com.example.expenserecord.model.Record;
import com.example.expenserecord.repository.ExpenseRepository;
import com.example.expenserecord.repository.mongo.entityrepo.CategoryRepository;
import com.example.expenserecord.repository.mongo.entityrepo.CustomerRepository;
import com.example.expenserecord.repository.mongo.entityrepo.MonetaryUnitRepository;
import com.example.expenserecord.repository.mongo.entityrepo.RecordRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mongoDB")
public class ExpenseRepositoryMongo implements ExpenseRepository {
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final MonetaryUnitRepository monetaryUnitRepository;
    private final RecordRepository recordRepository;

    public ExpenseRepositoryMongo(CategoryRepository categoryRepository,
                                  CustomerRepository customerRepository,
                                  MonetaryUnitRepository monetaryUnitRepository,
                                  RecordRepository recordRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.monetaryUnitRepository = monetaryUnitRepository;
        this.recordRepository = recordRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.insert(customer);
    }

    @Override
    public Record addRecord(Record record) {
        return recordRepository.insert(record);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.insert(category);
    }

    @Override
    public List<Record> getRecords() {
        return recordRepository.findAll();
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public MonetaryUnit addMonetaryUnit(MonetaryUnit monetaryUnit) {
        return monetaryUnitRepository.insert(monetaryUnit);
    }
    public List<MonetaryUnit> getMonetaryUnits() {
        return monetaryUnitRepository.findAll();
    }
}
