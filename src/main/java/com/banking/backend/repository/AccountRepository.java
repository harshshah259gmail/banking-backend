package com.banking.backend.repository;


import com.banking.backend.model.Account;
import com.banking.backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository  extends JpaRepository<Account,Integer> {

    Account findByAccountNumber(int accountNumber);

    List<Account> findByCustomerId(int customerId);
}
