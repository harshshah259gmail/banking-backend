package com.banking.backend.service;

import com.banking.backend.model.Customer;
import com.banking.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getcustomerbyIdcid(int cid) {
        return customerRepository.findByCustomerId(cid);
    }

    @Override
    public void deleteCustomer(int customerId) {
    customerRepository.deleteById(customerId);
    }
}
