package com.anicompany.fixtures;


import com.anicompany.bizlogic.ParseClientMoneyFile;

import java.math.BigDecimal;

/**
 * Created by Anirban on 4/27/2014.
 */
public class ClientMoneyParseSlim extends BaseSlim{

    private int owner;
    private int account;
    private String pool;
    private String amount;

    private String currency;
    //this is static, so that we dont lost the value for each run
    private static ParseClientMoneyFile parseClientMoneyFile = new ParseClientMoneyFile();
    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void execute() throws  Exception {
        parseClientMoneyFile.parseTokens(owner,account,pool,new BigDecimal(amount),currency);
        //System.out.println(parseClientMoneyFile.getClientMoneyMap());
    }

}
