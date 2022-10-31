package com.example.expenserecord.service;

import com.example.expenserecord.model.Category;
import com.example.expenserecord.model.Customer;
import com.example.expenserecord.model.MonetaryUnit;
import com.example.expenserecord.model.Record;
import com.example.expenserecord.repository.mongo.CategoryRepository;
import com.example.expenserecord.repository.mongo.CustomerRepository;
import com.example.expenserecord.repository.mongo.MonetaryUnitRepository;
import com.example.expenserecord.repository.mongo.RecordRepository;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class ExpenseService {
    private final CategoryRepository categoryRepository;
    private final RecordRepository recordRepository;
    private final MonetaryUnitRepository monetaryUnitRepository;
    private final CustomerRepository customerRepository;

    public ExpenseService(CategoryRepository categoryRepository,
                          RecordRepository recordRepository,
                          MonetaryUnitRepository monetaryUnitRepository,
                          CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.recordRepository = recordRepository;
        this.monetaryUnitRepository = monetaryUnitRepository;
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.insert(customer);
    }

    public Record addRecord(Record record) {
        verifyRecordUserAndCategory(record);
        if (isNull(record.getMoneyId())) {
            Customer customer = customerRepository.findById(record.getCustomerId()).orElseThrow(
                    () -> new RuntimeException("DB error: failed to fetch existing user"));
            record.setMoneyId(customer.getDefaultMoneyId());
        }
        return recordRepository.insert(record);
    }

    public Category addCategory(Category category) {
        return categoryRepository.insert(category);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public List<Record> getRecordsForCustomer(String customerId) {
        return recordRepository.findByCustomerId(customerId);
    }

    public List<Record> getCategoricalRecordsForCustomer(String customerId, String categoryId) {
        return recordRepository.findByCategoryIdAndCustomerId(customerId, categoryId);
    }

    public MonetaryUnit addMonetaryUnit(MonetaryUnit monetaryUnit) {
        return monetaryUnitRepository.insert(monetaryUnit);
    }

    public List<MonetaryUnit> getMonetaryUnits() {
        return monetaryUnitRepository.findAll();
    }

    private void verifyRecordUserAndCategory(Record record) {
        if (categoryRepository.existsById(record.getCategoryId())) {
            throw new ValidationException("Given record's category doesn't exist");
        }
        if (customerRepository.existsById(record.getCustomerId())) {
            throw new ValidationException("Given record's customer doesn't exist");
        }
    }
}
