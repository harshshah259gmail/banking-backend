package com.banking.backend.repository;

import com.banking.backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
    public interface CustomerRepository extends JpaRepository<Customer,Integer> {
        Customer findByCustomerId(int cid);
    }

