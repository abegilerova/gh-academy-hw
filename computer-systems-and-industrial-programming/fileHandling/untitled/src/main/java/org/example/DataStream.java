package org.example;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {
    //primitive types

    public static void main(String[] args) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("data.bin"))){
            out.writeInt(42);
            out.writeDouble(3.14);
            out.writeBoolean(true);
            out.writeUTF("Hello World");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
