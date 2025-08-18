package org.example.fileHandlingPart2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AcademyRepository implements IRepository2<Academy>{

    private String filePath = "academy.db";

    private List<Academy> readFromFile(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath)
        )){
            return (List<Academy>) in.readObject();

        }catch (IOException  | ClassNotFoundException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void add(Academy academy){
        List<Academy> academies = readFromFile();
        academies.add(academy);
        writeToFile(academies);
    }

    private void writeToFile(List<Academy>academies){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))){
            out.writeObject(academies);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

//    @Override
//    public List<Academy> getAll() {
//        return List.of();
//    }

//    @Override
//    public Academy getById(int id) {
//        return null;
//    }
//
//    @Override
//    public void update(Academy academy) {
//
//    }
//
//    @Override
//    public void remove(int id) {
//
//    }
}
