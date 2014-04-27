package com.anicompany.fixtures;

import com.anicompany.bizlogic.ClientMoneyCalculatorInMemoryImpl;
import com.anicompany.bizlogic.ParseClientMoneyFile;
import com.anicompany.domain.Account;
import com.anicompany.domain.Owner;

import java.util.*;

/**
 * Created by Anirban on 4/27/2014.
 */
public class ClientMoneyCalculationsSlim extends BaseSlim{
    private int accountId;

    public ClientMoneyCalculationsSlim(int accountId) {
        this.accountId = accountId;
    }


    public List<Object> query()
    {
        Map<Integer,Owner> clientMoneyMap = ParseClientMoneyFile.getClientMoneyMap();//retrieval information
        ClientMoneyCalculatorInMemoryImpl clientMoneyCalculatorInMemory = new ClientMoneyCalculatorInMemoryImpl();
        Set<Account> accountSet = clientMoneyCalculatorInMemory.getAccountsForSameOwner(clientMoneyMap, accountId);

        List<Object> table = new ArrayList();
        for (Account account : accountSet)
        {
            List<Object> row = new ArrayList();
            row.add(list(new Object[] { "accountNo", account.getAccountNumber() }));
            table.add(row);
        }
        return table;
    }

}
