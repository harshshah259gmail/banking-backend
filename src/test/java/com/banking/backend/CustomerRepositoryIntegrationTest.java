package com.banking.backend;

import com.banking.backend.model.Account;
import com.banking.backend.model.AccountType;
import com.banking.backend.model.Customer;
import com.banking.backend.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void whenFindById_thenReturnCustomer() {
        // given

        Account a = new Account(AccountType.SAVING,"USD",2000.0,1);
        Customer c = new Customer("Elon","Musk","Adress","1234566","SC122324");
        entityManager.persist(c);
        entityManager.persist(a);

        entityManager.flush();

        // when
        Customer found = customerRepository.findByCustomerId(c.getCustomerId());

        // then
        assertThat(found)
                .isEqualTo(c);
    }



}
