package com.example.expenserecord.security;

import com.example.expenserecord.model.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class JwtToCustomerConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {
    @Override
    public UsernamePasswordAuthenticationToken convert(Jwt jwt) {
        Customer customer = new Customer();
        customer.setId(jwt.getSubject());
        return new UsernamePasswordAuthenticationToken(customer, jwt, Collections.emptyList());
    }
}
