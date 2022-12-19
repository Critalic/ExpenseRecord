package com.example.expenserecord.controller;

import com.example.expenserecord.dto.CategoryDTO;
import com.example.expenserecord.dto.MonetaryUnitDTO;
import com.example.expenserecord.dto.RecordDTO;
import com.example.expenserecord.model.Category;
import com.example.expenserecord.model.MonetaryUnit;
import com.example.expenserecord.model.Record;
import com.example.expenserecord.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

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

    @PostMapping("record")
    public ResponseEntity<Record> addRecord(@RequestBody @Valid RecordDTO recordDTO) {
        return ResponseEntity.ok(service.addRecord(recordDTO.toRecord()));
    }

    @PostMapping("monetaryUnit")
    public ResponseEntity<MonetaryUnit> addMonetaryUnit(@RequestBody @Valid MonetaryUnitDTO monetaryUnit) {
        return ResponseEntity.ok(service.addMonetaryUnit(monetaryUnit.toMonetaryUnit()));
    }

    @GetMapping("monetaryUnit")
    public ResponseEntity<Collection<MonetaryUnit>> getMonetaryUnits() {
        return ResponseEntity.ok(service.getMonetaryUnits());
    }

    @PostMapping("category")
    public ResponseEntity<Category> addCategory(@RequestBody @Valid CategoryDTO category) {
        return ResponseEntity.ok(service.addCategory(category.toCategory()));
    }

    @GetMapping("category")
    public ResponseEntity<Collection<Category>> getCategories() {
        return ResponseEntity.ok(service.getCategories());
    }

    @GetMapping("record")
    public ResponseEntity<Collection<Record>> getRecordsForCustomer(@RequestParam String customerId) {
        return ResponseEntity.ok(service.getRecordsForCustomer(customerId));
    }

    @GetMapping("record/{categoryId}")
    public ResponseEntity<Collection<Record>> getCategoryRecordsForCustomer(@RequestParam String customerId,
                                                                            @PathVariable String categoryId) {
        return ResponseEntity.ok(service.getCategoricalRecordsForCustomer(customerId, categoryId));
    }
}
