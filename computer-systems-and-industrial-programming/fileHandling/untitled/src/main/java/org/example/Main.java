package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        FileInputStream in = null;
        FileOutputStream out = null;

        try{
            in = new FileInputStream("InFile.txt");
            out = new FileOutputStream("OutFile.txt");

            int byteData;
            while((byteData = in.read()) != -1){
                out.write(byteData);
            }

        } catch (IOException e){
            e.printStackTrace();

        } finally {
            try{
                if(in != null){
                    in.close();
                }

                if(out != null){
                    out.close();
                }

            }catch (IOException ex){
                ex.printStackTrace();
            }

        }

    }
}