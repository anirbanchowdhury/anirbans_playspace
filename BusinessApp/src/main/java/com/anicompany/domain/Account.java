package com.anicompany.domain;

/**
 * Created by Anirban on 4/19/2014.
 */
public class Account {
    private long accountNumber;
    private long owner;
    private Cash cash;

    public Account(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", owner=" + owner +
                ", cash=" + cash +
                '}';
    }
}
