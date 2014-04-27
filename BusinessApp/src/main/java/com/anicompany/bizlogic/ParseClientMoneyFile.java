package com.anicompany.bizlogic;

import com.anicompany.domain.Account;
import com.anicompany.domain.Cash;
import com.anicompany.domain.Owner;
import com.anicompany.domain.Pool;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Anirban on 4/19/2014.
 */
public class ParseClientMoneyFile {

    final static String TOKEN_DELIMITER = "\\|";
    final static String DIRECTORY = "E:\\porasona\\Intellij\\BusinessApp\\src\\main\\resources\\";

    //this is an architecture question, static is probably the easiest way out
    private static Map<Integer,Owner> clientMoneyMap = new HashMap<Integer,Owner>();

    //For now, its currency agnostic, FX conversions for next stage
    public  Map<Integer,Owner> parseOwnerLookupFile(File file) throws FileNotFoundException{
        Scanner scanner = new Scanner(file);


        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            parseEachLine(line);
        }
        System.out.println(clientMoneyMap);
        return clientMoneyMap;
    }

    /**
     *
     * @param line
     */
    public void parseEachLine(String line){
        System.out.println(line);
        //header
        if(line.contains("Owner")){
            return;
        }
        String []tokens = line.split(TOKEN_DELIMITER);
        Integer ownerId = Integer.parseInt(tokens[1]);
        int accountNumber = Integer.parseInt(tokens[2]);
        String poolId = tokens[3];
        BigDecimal amount = new BigDecimal(tokens[4]);
        String currencyCode = tokens[5];

        parseTokens(ownerId,accountNumber,poolId,amount,currencyCode);
    }

    /**
     *
     * @param ownerId
     * @param accountNumber
     * @param poolId
     * @param amount
     * @param currencyCode
     */
    public void parseTokens(int ownerId,int accountNumber,String poolId,BigDecimal amount,String currencyCode){
        Owner ownerFromMap = clientMoneyMap.get(ownerId);
        Map<Integer,Account> accountMap = null;
        Currency currency = Currency.getInstance(currencyCode);
        Cash cash = new Cash(amount,currency);
        Account account = new Account(accountNumber,cash);
        Pool pool = null;
        //new owner
        if(ownerFromMap == null){
            ownerFromMap = new Owner(ownerId);
            Map<String,Pool> newPoolMap = new HashMap<String, Pool>();
            pool = new Pool(poolId);
            newPoolMap.put(poolId, pool);
            accountMap =  new HashMap<Integer, Account>();
            //+new account
            account.setPool(pool);
            accountMap.put(accountNumber, account);
            //pool + new account
            pool.setAccountMap(accountMap);
            //owner + new pool
            ownerFromMap.setpoolMap(newPoolMap);
            //put owner in map
            clientMoneyMap.put(ownerId,ownerFromMap);

        }else{
            //owner exists in map

            pool = ownerFromMap.getpoolMap().get(poolId);
            if(pool  != null){
                //pool present in owner, new account?
                //no duplicate check, if the account comes again in the file, earlier entry overwritten

                pool.getAccountMap().put(accountNumber, account);
            }
            else{
                //new pool
                //new account
                accountMap =  new HashMap<Integer, Account>();
                accountMap.put(accountNumber,account);
                //new pool
                pool = new Pool(poolId);
                pool.setAccountMap(accountMap);

                //set pool to owner
                ownerFromMap.getpoolMap().put(poolId, pool);
            }
        }
        account.setPool(pool);
        pool.setOwner(ownerFromMap);
    }

    /**
     * This is ideally not reqd., as the data should be persisted to a database
     * @return
     */
    public static Map<Integer, Owner> getClientMoneyMap() {
        return clientMoneyMap;
    }

}
