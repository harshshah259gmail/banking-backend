package com.banking.backend.controller;


import com.banking.backend.model.Customer;
import com.banking.backend.model.CustomerDTO;
import com.banking.backend.service.AccountService;
import com.banking.backend.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    AccountService accountService;


    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/customers",method = RequestMethod.GET)
    public ResponseEntity<List<CustomerDTO>> getAllCustomer(){
        LOG.info("Request to get Customers");
        List<Customer> customers = customerService.getAllCustomer();
        List<CustomerDTO> customerDtos = convertToCustomerDTOS(customers);


        return new ResponseEntity<>(
                customerDtos,
                HttpStatus.OK);
    }
    @RequestMapping(value = "/{accoundId}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAccount(@RequestParam int customerId){
        LOG.info("Request to Delete Customer");

        customerService.deleteCustomer(customerId);


        return new ResponseEntity<>(
                customerId+" Customer Deleted SuccessFully",
                HttpStatus.OK);
    }
    @RequestMapping(value = "/customers/{cid}",method = RequestMethod.GET)
    public ResponseEntity<CustomerDTO> getCustomerByid(@RequestParam int cid){
        LOG.info("Request to get Customers");
        Customer customer = customerService.getcustomerbyIdcid(cid);
        CustomerDTO customerDto = converToCustomerDTO(customer);


        return new ResponseEntity<CustomerDTO>(
                customerDto,
                HttpStatus.OK);
    }

    @RequestMapping(value = "/customers",method = RequestMethod.PUT)
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerDTO customerdto){

        Customer customer = ConvertToCustomer(customerdto);
        customerService.saveCustomer(customer);

        return new ResponseEntity<>(
                customer.getCustomerId()+" Customer Added SuccessFully",
                HttpStatus.OK);
    }

    @RequestMapping(value = "/customers",method = RequestMethod.POST)
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerDTO customerdto){

        Customer customer = customerService.getcustomerbyIdcid(customerdto.getCustomerId());
        if(customer==null){
            return  new ResponseEntity<>(
                    "Custoemr Not present, customer id " + customer.getCustomerId(),
                    HttpStatus.NOT_ACCEPTABLE);
        }
         customer = ConvertToCustomer(customerdto);

        customerService.saveCustomer(customer);

        return new ResponseEntity<>(
                customerdto.getCustomerId()+" Customer Updated SuccessFully",
                HttpStatus.OK);
    }

    private Customer ConvertToCustomer(CustomerDTO customerdto) {
        Customer customer= new Customer();
        BeanUtils.copyProperties( customerdto,customer);
        return  customer;
    }

    private CustomerDTO converToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO= new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        customerDTO.setAccount(accountService.getAccountByCid(customerDTO.getCustomerId()));
        return  customerDTO;
    }

    private List<CustomerDTO> convertToCustomerDTOS(List<Customer> customers) {
        List<CustomerDTO> customerDTOS = new ArrayList<CustomerDTO>();

        customers.forEach(c->{
            CustomerDTO customerDTO = converToCustomerDTO(c);
            customerDTOS.add(customerDTO);
        });
        return customerDTOS;

    }


}
