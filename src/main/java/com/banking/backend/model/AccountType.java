package com.banking.backend.model;

public enum AccountType {
    CHECKING("CHECKING"), SAVING("SAVING"), CURRENT("CURRENT"), MONEY_MARKET("MONEY_MARKET");
    private String accountType;

    AccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}