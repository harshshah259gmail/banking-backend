package com.banking.backend.model;

import java.util.List;

public class CustomerDTO {

    private int customerId;
    private String firstName;
    private String lastName;
    private String address ;
    private String phoneNumber;
    private String sociaSecurityNumber;
    private List<Account> account;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSociaSecurityNumber() {
        return sociaSecurityNumber;
    }

    public void setSociaSecurityNumber(String sociaSecurityNumber) {
        this.sociaSecurityNumber = sociaSecurityNumber;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
}
