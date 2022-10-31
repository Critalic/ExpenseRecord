package com.example.expenserecord.dto;

import com.example.expenserecord.model.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CategoryDTO {
    @NotEmpty
    private String name;

    private Category toCategory() {
        Category category = new Category();
        category.setName(this.name);
        return category;
    }
}
