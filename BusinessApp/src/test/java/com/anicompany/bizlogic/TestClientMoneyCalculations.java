package com.anicompany.bizlogic;

import com.anicompany.domain.Owner;

import java.io.File;
import java.util.Map;

/**
 * Created by Anirban on 4/27/2014.
 */
public class TestClientMoneyCalculations extends BaseTestCase {

    public void testClientMoneyFileProcessing() throws Exception{

        String DIRECTORY = "E:\\porasona\\Intellij\\BusinessApp\\src\\main\\resources\\";

        Map<Integer,Owner> ownerMap = new ParseClientMoneyFile().parseOwnerLookupFile(new File(DIRECTORY + "clientmoneyfiles/owner_lookup.txt"));

        assertEquals(new ClientMoneyCalculatorInMemoryImpl().getAccountsForSameOwner(ownerMap,1001).size(),3);
        assertEquals(new ClientMoneyCalculatorInMemoryImpl().getAccountsForSameOwner(ownerMap,2001).size(),1);

    }
}
