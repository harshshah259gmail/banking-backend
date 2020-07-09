package com.banking.backend.model;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "account_number")
        private Integer accountNumber;

        @Column(name = "account_type")
        @Enumerated(EnumType.STRING)
        private AccountType accountType;

        @Column(name = "currency_type")
        private String currencyType;

        @Column(name = "amount")
        private Double amount;

        @Column(name = "customer_id")
        private int customerId;

        public Integer getAccountNumber() {
                return accountNumber;
        }

        public void setAccountNumber(Integer accountNumber) {
                this.accountNumber = accountNumber;
        }

        public AccountType getAccountType() {
                return accountType;
        }

        public void setAccountType(AccountType accountType) {
                this.accountType = accountType;
        }

        public String getCurrencyType() {
                return currencyType;
        }

        public void setCurrencyType(String currencyType) {
                this.currencyType = currencyType;
        }

        public Double getAmount() {
                return amount;
        }

        public void setAmount(Double amount) {
                this.amount = amount;
        }

        public int getCustomerId() {
                return customerId;
        }

        public void setCustomerId(int customerId) {
                this.customerId = customerId;
        }

        public Account(){}
        public Account( AccountType accountType, String currencyType, Double amount, int customerId) {

                this.accountType = accountType;
                this.currencyType = currencyType;
                this.amount = amount;
                this.customerId = customerId;
        }
}
