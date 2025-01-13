package java_hw.finalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

static class ClientHandler implements Runnable {
    private final Socket socket;
    private PrintWriter out;
    private String username;

    ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ){
            this.out = out;
            out.println("Welcome to the chat! Please enter your username:");
            username = reader.readLine();
            DatabaseConnection.saveUer(username);

        }catch (IOException e){
            System.out.println("Error handling client: " + e.getMessage());


        }

    }

}
