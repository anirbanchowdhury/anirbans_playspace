package com.anicompany.domain;

import java.util.Set;

/**
 * Created by Anirban on 4/19/2014.
 */
public class ClientMoney {
    private int owner;
    private String pool;
    private Set<Account> accountSet;

    public ClientMoney(int owner, String pool, Set<Account> accountSet) {
        this.owner = owner;
        this.pool = pool;
        this.accountSet = accountSet;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public Set<Account> getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }

    @Override
    public String toString() {
        return "ClientMoney{" +
                "owner=" + owner +
                ", pool='" + pool + '\'' +
                ", accountSet=" + accountSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientMoney that = (ClientMoney) o;

        if (owner != that.owner) return false;
        if (pool != null ? !pool.equals(that.pool) : that.pool != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = owner;
        result = 31 * result + (pool != null ? pool.hashCode() : 0);
        return result;
    }
}
