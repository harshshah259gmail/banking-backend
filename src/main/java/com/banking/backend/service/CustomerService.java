package com.banking.backend.service;

import com.banking.backend.model.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomer();
    void  saveCustomer(Customer customer);
    Customer getcustomerbyIdcid(int cid);
    void deleteCustomer(int custoemrId);
}
