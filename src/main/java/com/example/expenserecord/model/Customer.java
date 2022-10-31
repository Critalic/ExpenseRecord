package com.example.expenserecord.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Customer {
    @Id
    private String id;
    private String defaultMoneyId;
    @Indexed(unique = true)
    private String name;

    public Customer(String defaultMoneyId, String name) {
        this.defaultMoneyId = defaultMoneyId;
        this.name = name;
    }
}
