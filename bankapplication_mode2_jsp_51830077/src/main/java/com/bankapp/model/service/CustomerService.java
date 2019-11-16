package com.bankapp.model.service;

import com.bankapp.model.entities.Customer;

public interface CustomerService {
public Customer findById(Long id);
public void updateCustomer(Customer customer);
}
