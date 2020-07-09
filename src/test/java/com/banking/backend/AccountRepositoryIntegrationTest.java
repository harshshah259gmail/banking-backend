package com.banking.backend;

import com.banking.backend.model.Account;
import com.banking.backend.model.AccountType;
import com.banking.backend.model.Customer;
import com.banking.backend.repository.AccountRepository;
import com.banking.backend.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryIntegrationTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;


    @Test
    public void whenFindById_thenReturnAccount() {
        // given

        Account a = new Account(AccountType.SAVING,"USD",2000.0,1);
        Customer c = new Customer("Elon","Musk","Adress","1234566","SC122324");
        entityManager.persist(c);
        entityManager.persist(a);

        entityManager.flush();

        // when
        Account found = accountRepository.findByAccountNumber(a.getAccountNumber());
        // then
        assertThat(found)
                .isEqualTo(a);
    }

    @Test
    public void whenFindByCustomerId_thenReturnAccount() {
        // given

        Account a = new Account(AccountType.SAVING,"USD",2000.0,1);
        Customer c = new Customer("Elon","Musk","Adress","1234566","SC122324");
        entityManager.persist(c);
        entityManager.persist(a);

        entityManager.flush();

        // when
        List<Account> found = accountRepository.findByCustomerId(a.getCustomerId());
        // then
        assertThat(found.get(0))
                .isEqualTo(a);
    }
}
