package org.example.fileBasedDatabase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IRepository<User>{
    private final String filePath = "users.db";
    File file = new File("users.db");

    //reading = deserialization
    private List<User> readFromFile(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            return (List<User>) in.readObject();
        }catch(IOException  | ClassNotFoundException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void writeToFile(List<User> users){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))){
             out.writeObject(users);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void add(User user){
        List<User> users = readFromFile();
        users.add(user);
        writeToFile(users);
    }

    @Override
    public List<User> getAll(){
        return readFromFile();
    }

    @Override
    public User getById(int id){
        return readFromFile().stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(User updatedUser) {
        List<User> users = readFromFile();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == updatedUser.getId()) {
                users.set(i, updatedUser);
                break;
            }
        }
        writeToFile(users);
    }

    @Override
    public void remove(int id) {
        List<User> users = readFromFile();
        users.removeIf(u -> u.getId() == id);
        writeToFile(users);
    }
}

