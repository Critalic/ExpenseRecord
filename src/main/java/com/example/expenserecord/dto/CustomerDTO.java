package com.example.expenserecord.dto;

import com.example.expenserecord.model.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {
    @NotEmpty(message = "Default money id can't be empty")
    private String defaultMoneyId;
    @NotEmpty(message = "Customer's name can't be empty")
    private String name;

    public Customer toCustomer() {
        return new Customer(this.defaultMoneyId, this.name);
    }
}
