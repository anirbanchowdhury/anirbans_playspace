package com.anicompany.bizlogic;

import com.anicompany.domain.Account;
import com.anicompany.domain.Owner;
import com.anicompany.domain.Pool;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Anirban on 4/27/2014.
 */
public class ClientMoneyCalculatorInMemoryImpl implements  ClientMoneyCalculations {

    /**
     *
     * @param ownerMap
     * @param accountNo
     * @return
     */
    public Set<Account> getAccountsForSameOwner(Map<Integer,Owner> ownerMap, int  accountNo){

        Pool pool = getPoolFromAccount(ownerMap,accountNo);
        if(pool == null){
            return null;
        }
        Set<Account> accountSet =  new HashSet<Account>();
        Owner owner = pool.getOwner();
        for(Map.Entry<String,Pool> poolEntry:owner.getpoolMap().entrySet()){
            Pool localPool = poolEntry.getValue();
            for(Map.Entry<Integer,Account> accountEntry: localPool.getAccountMap().entrySet()){
                accountSet.add(accountEntry.getValue());
            }
        }
       return accountSet;
    }

    /**
     *
     * @param ownerMap
     * @param accountNo
     * @return
     */
    public Pool getPoolFromAccount(Map<Integer,Owner> ownerMap,int accountNo){
        for(Map.Entry<Integer,Owner> ownerEntry:ownerMap.entrySet()){
            Owner owner = ownerEntry.getValue();
            for(Map.Entry<String,Pool> poolEntry: owner.getpoolMap().entrySet()){
                Pool pool = poolEntry.getValue();
                if((pool.getAccountMap().get(accountNo)) != null){
                    return pool;
                }
            }
        }
        return null;
    }

    @Override
    public Map<Pool, BigDecimal> getPoolLevelBalanceFromAccount(Map<Integer,Owner> ownerMap, int accountNo) {
        return null;
    }


}
