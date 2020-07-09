package com.banking.backend.service;

import com.banking.backend.model.Account;
import com.banking.backend.repository.AccountRepository;
import com.banking.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAllAccount() {
       return accountRepository.findAll();
    }

    @Override
    public Account findByAccountNumber(int accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Transactional(rollbackOn = {RuntimeException.class})
    public String transferAmount(int fromAccountNumber, int toAccountNumer,double amount){

        String transactionNumber = "T"+new Date().getTime()+Math.random();
        Account from = accountRepository.findByAccountNumber(fromAccountNumber);
        from.setAmount(from.getAmount()-amount);
        Account to = accountRepository.findByAccountNumber(toAccountNumer);
        to.setAmount(to.getAmount()+amount);

        accountRepository.save(from);
        accountRepository.save(to);

        return transactionNumber;
    }

    @Override
    public List<Account> findByCusomerId(int customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

    @Override
    public int addAccount(Account account) {

        Account a = accountRepository.save(account);
        return a.getAccountNumber();
    }

    @Override
    public void deleteAccount(int accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public List<Account> getAccountByCid(int customerId) {
        return accountRepository.findByCustomerId(customerId);
    }


}
