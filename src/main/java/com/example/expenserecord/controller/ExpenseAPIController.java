package com.example.expenserecord.controller;

import com.example.expenserecord.dto.CustomerDTO;
import com.example.expenserecord.dto.RecordDTO;
import com.example.expenserecord.model.Category;
import com.example.expenserecord.model.Customer;
import com.example.expenserecord.model.MonetaryUnit;
import com.example.expenserecord.model.Record;
import com.example.expenserecord.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/")
public class ExpenseAPIController {
    private final ExpenseService service;

    public ExpenseAPIController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<String> getDefault() {
        return ResponseEntity.ok("Hello from expense record api");
    }

    @PostMapping("customer")
    public Customer addCustomer(@RequestBody @Valid CustomerDTO customer) {
        return service.addCustomer(customer.toCustomer());
    }

    @PostMapping("record")
    public Record addRecord(@RequestBody @Valid RecordDTO record) {
        return service.addRecord(record);
    }

    @PostMapping("monetaryUnit")
    public MonetaryUnit addMonetaryUnit(@RequestBody @Valid MonetaryUnit monetaryUnit) {
        return service.addMonetaryUnit(monetaryUnit);
    }

    @GetMapping("monetaryUnit")
    public Collection<MonetaryUnit> getMonetaryUnits() {
        return service.getMonetaryUnits();
    }

    @PostMapping("category")
    public Category addCategory(@RequestBody @Valid Category category) {
        return service.addCategory(category);
    }

    @GetMapping("category")
    public Collection<Category> getCategories() {
        return service.getCategories();
    }

    @GetMapping("record")
    public Collection<Record> getRecordsForCustomer(@RequestParam String customerId) {
        return service.getRecordsForCustomer(customerId);
    }

    @GetMapping("record/{categoryId}")
    public List<Record> getCategoryRecordsForCustomer(@RequestParam String customerId,
                                                     @PathVariable String categoryId) {
        return service.getCategoricalRecordsForCustomer(customerId, categoryId);
    }
}
