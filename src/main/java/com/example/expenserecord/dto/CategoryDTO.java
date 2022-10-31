package com.example.expenserecord.dto;

import com.example.expenserecord.model.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CategoryDTO {
    @NotEmpty
    @NotEmpty(message = "Category name can't be empty")
    private String name;

    public Category toCategory() {
        return new Category(this.name);
    }
}
