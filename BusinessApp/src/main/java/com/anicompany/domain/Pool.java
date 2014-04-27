package com.anicompany.domain;

import java.util.Map;
import java.util.Set;

/**
 * Created by Anirban on 4/19/2014.
 */
public class Pool {

    private String poolName;
    private Map<Integer,Account> accountMap;
    private Owner owner;

    public Pool(String pool, Map<Integer,Account> accountMap) {
        this.poolName = pool;
        this.accountMap = accountMap;
    }



    public Pool(String poolName) {
        this.poolName = poolName;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public Map<Integer, Account> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(Map<Integer, Account> accountMap) {
        this.accountMap = accountMap;
    }

    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pool{" +
                ", poolName='" + poolName + '\'' +
                ", accountMap=" + accountMap +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pool)) return false;

        Pool pool = (Pool) o;

        if (poolName != null ? !poolName.equals(pool.poolName) : pool.poolName != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        return poolName != null ? poolName.hashCode() : 0;
    }
}
