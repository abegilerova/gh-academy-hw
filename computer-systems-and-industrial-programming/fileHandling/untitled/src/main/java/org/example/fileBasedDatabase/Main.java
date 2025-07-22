package org.example.fileBasedDatabase;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepo = new UserRepository();
        User user1 = new User("Aika", "1234");
        userRepo.add(user1);
    }
}
