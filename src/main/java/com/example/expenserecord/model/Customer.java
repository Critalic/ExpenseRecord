package com.example.expenserecord.model;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springdoc.core.converters.models.MonetaryAmount;
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
    private Long id;
    @NotNull
    @EqualsAndHashCode.Exclude
    private Long defaultMoneyId;
    @NotEmpty(message = "Customer's name can't be empty")
    private String name;
}
