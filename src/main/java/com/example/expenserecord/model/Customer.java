package com.example.expenserecord.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class Customer {
    @EqualsAndHashCode.Exclude
    private Long id;
    @NotEmpty(message = "Customer's name can't be empty")
    private String name;
}
