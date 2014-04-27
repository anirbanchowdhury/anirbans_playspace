package com.anicompany.bizlogic;

import com.anicompany.domain.Account;
import com.anicompany.domain.Owner;
import com.anicompany.domain.Pool;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

/**
 * Created by Anirban on 4/27/2014.
 * Gen. purpose API to do the following :
 * a. Pass accountId : retrieve rest of the accounts under the owner
 * b. Pass accountId : retrieve the balance summed @ pool level
 *
 * Eg. if
 * |Owner|Account|Pool|Amount|Currency|
   |100|1001|Savings|100|USD|
   |100|1002|Trading|200|USD|
   |200|2001|Savings|50|USD|
   |100|1003|Trading|1000|USD|

 then, a. If I pass 1001,I should get 1001, 1002, 1003 because all belong to the same owner
       b. If I pass 1001, I should get Savings : 1100 USD, Trading 50 USD
          If I pass 2001, I should get Savings : 50 USD.

 Note: For iteration1, its currency agnostic, FX conversions are for a later version.

 */
public interface ClientMoneyCalculations {

    //This is ideally not reqd. since the Map can be considerably huge depending on the size of the feed file
    public Set<Account> getAccountsForSameOwner(Map<Integer,Owner> ownerMap, int accountNo);

    public Map<Pool,BigDecimal> getPoolLevelBalanceFromAccount(Map<Integer,Owner> ownerMap, int accountNo);

    public Pool getPoolFromAccount(Map<Integer,Owner> ownerMap, int accountNo);

}
