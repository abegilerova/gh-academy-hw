package java_hw.finalProject;

import java.sql.*;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:sqlite:/Users/aikanysh/growthhungry/gh-academy-hw/java-intensive/src/main/java/java_hw/finalProject/chat.db";

    static void initializeDatabase (){
        try(Connection connection = DriverManager.getConnection(DB_URL);
            Statement stmt = connection.createStatement()){
            String userTable = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT UNIQUE);";
            String messageTable = "CREATE TABLE IF NOT EXISTS messages (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, message TEXT, " +
                    "timestamp DATETIME DEFAULT CURRENT_TIMESTAMP);";
            stmt.execute(userTable);
            stmt.execute(messageTable);

        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }

    static void saveUser(String username){
        String insertUserSQL = "INSERT OR IGNORE INTO users (username) VALUES (?);";
        try(Connection connection = DriverManager.getConnection(DB_URL);
            PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL)){
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving user: " + e.getMessage());
        }
    }

    static void saveMessage(String username, String message){
        String insertUserSQL = "INSERT OR IGNORE INTO messages (username,message) VALUES (?,?);";
        try(Connection connection = DriverManager.getConnection(DB_URL);
            PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL)){
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,message);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving message: " + e.getMessage());
        }
    }
}
