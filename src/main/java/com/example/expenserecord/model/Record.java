package com.example.expenserecord.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Record {
    @Id
    private String id;
    private String moneyId;
    private String customerId;
    private String categoryId;
    private BigDecimal amount;
    private LocalDateTime creationTime;

    public Record(String moneyId, String customerId, String categoryId, BigDecimal amount, LocalDateTime creationTime) {
        this.moneyId = moneyId;
        this.customerId = customerId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.creationTime = creationTime;
    }
}
