package com.example.expenserecord.model;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Category {
    @Id
    @EqualsAndHashCode.Exclude
    private String id;
    @Indexed(unique = true)
    @NotEmpty(message = "Category name can't be empty")
    private String name;
}
