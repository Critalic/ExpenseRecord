package com.example.expenserecord.dto;

import com.example.expenserecord.model.MonetaryUnit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Currency;

@Getter
@Setter
@NoArgsConstructor
public class MonetaryUnitDTO {
    @NotEmpty(message = "Currency code can't be null")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Incorrect currency code format")
    private String currencyCode;

    public MonetaryUnit toMonetaryUnit() {
        MonetaryUnit monetaryUnit = new MonetaryUnit();
        monetaryUnit.setCurrency(Currency.getInstance(currencyCode));
        return monetaryUnit;
    }
}
