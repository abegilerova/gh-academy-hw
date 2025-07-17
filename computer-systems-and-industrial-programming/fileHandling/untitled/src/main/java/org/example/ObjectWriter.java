package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriter {
    public static void main(String[] args) {
        try(FileOutputStream fileOut = new FileOutputStream("person.ser");
            ObjectOutputStream outObject = new ObjectOutputStream(fileOut)){

            Person aika = new Person("Aika", 32);
            outObject.writeObject(aika);
            System.out.println("Object written to person.ser");

        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
