package com.bankapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.Customer;
import com.bankapp.model.repo.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public Customer findById(Long id) {
		Customer customer=customerRepository.findById(id).orElseThrow(RuntimeException::new);
		return customer;
	}
	@Override
	public void updateCustomer(Customer customer) {
		Customer customer2=customerRepository.save(customer);
		
	}

}
