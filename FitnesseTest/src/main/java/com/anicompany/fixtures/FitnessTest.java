package com.anicompany.fixtures;

import com.anicompany.bizlogic.ParseClientMoneyFile;
import com.anicompany.domain.ClientMoney;


import java.util.Set;

/**
 * Created by Anirban on 4/19/2014.
 */
public class FitnessTest {
    public  static void main(String []args) throws Exception{
        Set<ClientMoney> clientMoneySet = new ParseClientMoneyFile().parseOwnerLookupFile();
        System.out.println(clientMoneySet);
    }

    private String owner;
    private String account;
    private String lockupPool;

    private String accounts;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLockupPool() {
        return lockupPool;
    }

    public void setLockupPool(String lockupPool) {
        this.lockupPool = lockupPool;
    }

    public String accounts()throws Exception {

        Set<ClientMoney> clientMoneySet = new ParseClientMoneyFile().parseOwnerLookupFile();
        System.out.println(clientMoneySet);
        return accounts;
    }


}
