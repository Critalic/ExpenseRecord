package com.example.expenserecord.controller;

import com.example.expenserecord.model.Category;
import com.example.expenserecord.model.Customer;
import com.example.expenserecord.model.Record;
import com.example.expenserecord.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
    public void addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
    }

    @PostMapping("record")
    public void addRecord(@RequestBody Record record) {
        service.addRecord(record);
    }

    @PostMapping("category")
    public void addCategory(@RequestBody Category category) {
        service.addCategory(category);
    }

    @GetMapping("category")
    public Set<Category> getCategories() {
        return service.getCategories();
    }

    @GetMapping("record")
    public Set<Record> getRecordsForCustomer(@RequestParam Long customerId) {
        return service.getRecordsForCustomer(customerId);
    }

    @GetMapping("record/{categoryId}")
    public Set<Record> getCategoryRecordsForCustomer(@RequestParam Long customerId,
                                                     @PathVariable Long categoryId) {
        return service.getCategoricalRecordsForCustomer(customerId, categoryId);
    }
}
