package com.example.expenserecord.dto;

import com.example.expenserecord.model.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CustomerDTO {
    @NotEmpty
    private String defaultMoneyId;
    @NotEmpty
    private String name;

    public Customer toCustomer() {
        Customer customer = new Customer();
        customer.setDefaultMoneyId(this.defaultMoneyId);
        customer.setName(this.name);
        return customer;
    }
}
