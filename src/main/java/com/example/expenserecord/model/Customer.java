package com.example.expenserecord.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Customer {
    @NonNull
    private Long id;
    @NonNull
    private String name;
}
