package com.banking.backend.controller;

import com.banking.backend.model.Account;
import com.banking.backend.model.AccountDTO;
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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {


    @Autowired
    AccountService accountService;
    @Autowired
    CustomerService customerService;

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public  ResponseEntity<List<AccountDTO>> getAllAccounts(){
        LOG.info("Request to get Accounts");
        List<Account> accounts = accountService.getAllAccount();

        List<AccountDTO> accountDTOS = convertToAccountrDTOS(accounts);


        return new ResponseEntity<>(
                accountDTOS,
                HttpStatus.OK);
    }
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public  ResponseEntity<String> addAccount(@RequestBody AccountDTO accountDTO){
        LOG.info("Request to get Accounts");

        //Check if Customer exists or not
        Customer customer = customerService.getcustomerbyIdcid(accountDTO.getCustomerId());
        if(customer==null){
            return  new ResponseEntity<String>(
                    "Customer  Not present " + accountDTO.getCustomerId(),
                    HttpStatus.NOT_ACCEPTABLE);
        }

        Account account = convertToAccount(accountDTO);

        int accountNumber = accountService.addAccount(account);

        return new ResponseEntity<>(
                accountNumber+"",
                HttpStatus.OK);
    }




    @RequestMapping(value = "/{customerId}",method = RequestMethod.GET)
    public  ResponseEntity<List<AccountDTO>> getAllAccountsByCustomerId(@RequestParam int customerId){

        LOG.info("Request to get Accounts");
        List<Account> accounts = accountService.findByCusomerId(customerId);
        List<AccountDTO> accountDTOS = convertToAccountrDTOS(accounts);


        return new ResponseEntity<>(
                accountDTOS,
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{accoundId}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAccount(@RequestParam int accountId){
        LOG.info("Request to Delete Accounts");
        accountService.deleteAccount(accountId);


        return new ResponseEntity<>(
                accountId+" Deleted SuccessFully",
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{accountNumber}",method = RequestMethod.GET)
    public ResponseEntity<AccountDTO> getAccountDetails(@RequestParam int accountNumber){
        LOG.info("Request to get Accounts");
        Account account = accountService.findByAccountNumber(accountNumber);

       AccountDTO accountDTO = converToAccountDTO(account);


        return new ResponseEntity<>(
                accountDTO,
                HttpStatus.OK);
    }
    @RequestMapping(value = "/transfer",method = RequestMethod.POST)
    private ResponseEntity<String> transferAmount(@RequestBody Map<String,Object> body) throws Exception {

         String transactionId = "";
         int fromAccountNumber = Integer.parseInt(body.get("fromAccountNumber").toString());
         int toAccountNumber = Integer.parseInt(body.get("toAccountNumber").toString());
         double amount  = Double.parseDouble(body.get("amount").toString());

         //Check Balance & from account
         Account account = accountService.findByAccountNumber(fromAccountNumber);
         if(account==null){
             return  new ResponseEntity<>(
                     "From Account Not present " + fromAccountNumber,
                     HttpStatus.NOT_ACCEPTABLE);
         }
         if(account.getAmount()<amount){

            return  new ResponseEntity<>(
                     "Don't have enough money in Account " + toAccountNumber,
                     HttpStatus.NOT_ACCEPTABLE);
         }
         //Check To Account
         account = accountService.findByAccountNumber(toAccountNumber);
        if(account==null){
            return  new ResponseEntity<>(
                    "To Account Not present " + account.getAccountNumber(),
                    HttpStatus.NOT_ACCEPTABLE);
        }

         //Transfer Money
        accountService.transferAmount(fromAccountNumber,toAccountNumber,amount);

        return new ResponseEntity<>(
                "Trasaction Completed with ID :  " + transactionId,
                HttpStatus.OK);
    }

    private List<AccountDTO> convertToAccountrDTOS(List<Account> accounts) {
        List<AccountDTO> accountDTOS = new ArrayList<AccountDTO>();

        accounts.forEach(a->{
            AccountDTO accountDTO = converToAccountDTO(a);
            accountDTOS.add(accountDTO);
        });
        return accountDTOS;
    }

    private AccountDTO converToAccountDTO(Account account) {
        AccountDTO accountDTO= new AccountDTO();
        BeanUtils.copyProperties(account,accountDTO);
        return  accountDTO;
    }
    private Account convertToAccount(AccountDTO accountDTO) {
        Account account= new Account();
        BeanUtils.copyProperties(accountDTO,account);
        return  account;
    }



}
