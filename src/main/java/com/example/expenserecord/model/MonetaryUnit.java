package com.example.expenserecord.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Currency;

@Getter
@Setter
@NoArgsConstructor
@Document
public class MonetaryUnit {
    @Id
    @EqualsAndHashCode.Exclude
    private String id;
    @Indexed(unique = true)
    @NotNull(message = "Currency code can't be null")
    private Currency currency;

    public MonetaryUnit(Currency currency) {
        this.currency = currency;
    }
}
