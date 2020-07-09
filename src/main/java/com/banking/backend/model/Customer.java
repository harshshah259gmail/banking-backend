package com.banking.backend.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String address ;
    @Column(name = "phone_number")

    private String phoneNumber;

    @JsonIgnore
    @Column(name = "social_security_number")
    private String sociaSecurityNumber;


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
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


    public Customer(){}
    public Customer( String firstName, String lastName, String address, String phoneNumber, String sociaSecurityNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sociaSecurityNumber = sociaSecurityNumber;

    }
}

