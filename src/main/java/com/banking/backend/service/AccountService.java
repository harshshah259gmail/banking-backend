package com.banking.backend.service;

import com.banking.backend.model.Account;
import com.banking.backend.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {

    public List<Account> getAllAccount();

    public Account findByAccountNumber(int accountNumber);

    public String transferAmount(int fromAccountNumber, int toAccountNumer,double amount);

    List<Account> findByCusomerId(int customerId);

    int addAccount(Account account);

    void deleteAccount(int accountId);

    List<Account> getAccountByCid(int customerId);
}
