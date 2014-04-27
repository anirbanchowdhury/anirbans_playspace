package com.anicompany.bizlogic;

import com.anicompany.domain.Owner;

import java.io.File;
import java.util.Map;

/**
 * Created by Anirban on 4/27/2014.
 */
public class TestParseClientMoneyFile extends BaseTestCase {


    public void testClientMoneyFileProcessing() throws Exception{
        String DIRECTORY = "E:\\porasona\\Intellij\\BusinessApp\\src\\main\\resources\\";

        Map<Integer,Owner> ownerMap = new ParseClientMoneyFile().parseOwnerLookupFile(new File(DIRECTORY + "clientmoneyfiles/owner_lookup.txt"));
        assertEquals(ownerMap.size(), 2);

        assertEquals(ownerMap.get(100).getpoolMap().get("Trading").getAccountMap().size(), 2);
        assertEquals(ownerMap.get(100).getpoolMap().get("Savings").getAccountMap().size(),1);

        assertNull(ownerMap.get(200).getpoolMap().get("Trading"));
        assertEquals(ownerMap.get(200).getpoolMap().get("Savings").getAccountMap().size(),1);

    }
}

