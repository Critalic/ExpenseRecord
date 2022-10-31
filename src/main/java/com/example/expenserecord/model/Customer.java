package com.example.expenserecord.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Customer {
    @Id
    @EqualsAndHashCode.Exclude
    private String id;
    @NotNull
    @EqualsAndHashCode.Exclude
    private String defaultMoneyId;
    @Indexed(unique = true)
    @NotEmpty(message = "Customer's name can't be empty")
    private String name;
}
