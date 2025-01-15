package java_hw.finalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java_hw.finalProject.ChatServer.broadcast;
import static java_hw.finalProject.ChatServer.removeClient;

class ClientHandler implements Runnable {
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
            DatabaseConnection.saveUser(username);
            broadcast(username + " has joined the chat.", this);
            String message;
            while ((message = reader.readLine()) != null){
                if(message.equalsIgnoreCase("exit")){
                    break;
                }
                String formattedMessage = username + ": " + message;
                DatabaseConnection.saveMessage(username, message);
                System.out.println(formattedMessage);
                broadcast(formattedMessage, this);
            }
        }catch (IOException e){
            System.out.println("Error handling client: " + e.getMessage());

        }finally {
            try{
                socket.close();
            }catch(IOException e){
                System.out.println("Error closing socket: " + e.getMessage());
            }
            removeClient(this);
            broadcast(username + " has left the chat", this);

        }

    }

    void sendMessage(String message){
        out.println(message);
    }

}
