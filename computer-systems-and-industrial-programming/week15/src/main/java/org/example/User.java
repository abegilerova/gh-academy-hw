package org.example;

import java.util.List;

public class User {
    String name;
    List<Account> allAccounts;

    public User(String name){
        this.name = name;
    }

    public void openAccount (){
        System.out.println("opening account");
    }

}
