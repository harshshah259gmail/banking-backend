package com.banking.backend;

import com.banking.backend.model.Customer;
import com.banking.backend.repository.CustomerRepository;
import com.banking.backend.service.CustomerService;
import com.banking.backend.service.CustomerServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
public class MokitoCustomerServiceTest {

    @TestConfiguration
    static class CustomerServiceImplTestConfiguration {

        @Bean
        public CustomerService customerService() {
            return new CustomerServiceImpl();
        }
    }

    @Before
    public void setUp() {
        Customer elon = new Customer("Elon","Musk","Adress","1234566","SC122324");

        Mockito.when(customerRepository.findByCustomerId(1))
                .thenReturn(elon);
    }

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void whenValidCid_thenEmployeeShouldBeFound() {

        Customer found = customerService.getcustomerbyIdcid(1);
        Assertions.assertThat(found.getCustomerId())
                .isEqualTo(1);
    }

}
