package com.example.expenserecord.dto;

import com.example.expenserecord.model.MonetaryUnit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Currency;

@Getter
@Setter
@NoArgsConstructor
public class MonetaryUnitDTO {
    @NotEmpty(message = "Category id can't be null")
    private String currencyCode;

    public MonetaryUnit toMonetaryUnit() {
        MonetaryUnit monetaryUnit = new MonetaryUnit();
        monetaryUnit.setCurrency(Currency.getInstance(currencyCode));
        return monetaryUnit;
    }
}
