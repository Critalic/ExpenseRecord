package com.example.expenserecord.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Currency;

@Getter
@Setter
@NoArgsConstructor
@Document
public class MonetaryUnit {
    @Id
    private String id;
    @Indexed(unique = true)
    private Currency currency;

    public MonetaryUnit(Currency currency) {
        this.currency = currency;
    }
}
