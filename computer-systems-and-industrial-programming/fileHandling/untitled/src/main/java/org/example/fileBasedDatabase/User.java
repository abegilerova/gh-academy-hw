package org.example.fileBasedDatabase;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private transient String password;

    public User(String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId(){
        return id;
    }
}
