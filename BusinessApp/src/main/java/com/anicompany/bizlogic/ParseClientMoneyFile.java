package com.anicompany.bizlogic;

import com.anicompany.domain.Account;
import com.anicompany.domain.ClientMoney;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Anirban on 4/19/2014.
 */
public class ParseClientMoneyFile {

    final static String TOKEN_DELIMITER = "\\|";
    final static String DIRECTORY = "E:\\porasona\\Intellij\\BusinessApp\\src\\main\\resources\\";
    Set<ClientMoney> clientMoneySet = new HashSet<ClientMoney>();

    public Set<ClientMoney> parseOwnerLookupFile() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(DIRECTORY+"clientmoneyfiles/owner_lookup.txt"));
        int currentOwner = -1;
        int owner = -1;
        Set<Account> accountSet = null;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            //header
            if(line.contains("Owner")){
                continue;

            }
            String []tokens = line.split(TOKEN_DELIMITER);
            owner = Integer.parseInt(tokens[1]);
            if(owner != currentOwner){
                accountSet =  new HashSet<Account>();
                currentOwner = owner;
                String pool = tokens[3];
                ClientMoney clientMoney = new ClientMoney(currentOwner,pool,accountSet);
                clientMoneySet.add(clientMoney);
            }
            int accountNumber = Integer.parseInt(tokens[2]);
            accountSet.add(new Account(accountNumber));
        }
        System.out.println(clientMoneySet);
        return clientMoneySet;
    }





    public static  void main(String []args) throws Exception{
        new ParseClientMoneyFile().parseOwnerLookupFile();
    }
}
