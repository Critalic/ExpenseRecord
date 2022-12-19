package com.example.expenserecord.service;

import com.example.expenserecord.model.Customer;
import com.example.expenserecord.repository.mongo.CustomerRepository;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsManager {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(UserDetails customer) {
        ((Customer) customer).setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.insert(((Customer) customer));
    }

    @Override
    public void updateUser(UserDetails user) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteUser(String username) {
        throw new NotImplementedException();
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        throw new NotImplementedException();
    }

    @Override
    public boolean userExists(String username) {
        return customerRepository.existsByName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByName(username).orElseThrow(RuntimeException::new);
    }
}
