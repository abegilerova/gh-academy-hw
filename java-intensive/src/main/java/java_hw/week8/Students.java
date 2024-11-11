package java_hw.week8;

import java.sql.*;

public class Students {

    private static final String URL = "jdbc:sqlite:/Users/aikanysh/growthhungry/gh-academy-hw/java-intensive/src/main/java/java_hw/week8/students.db";

    public static void main (String [] args )  {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Students studentsApp = new Students();

        try {
            conn = DriverManager.getConnection(URL);
            stmt = conn.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, " +"name TEXT," + "age INTEGER," + "grade REAL" + ")";
            stmt.executeUpdate(createTableSQL);

            //insert data using prepared statement
            String insertData = "INSERT INTO students (name, age, grade) VALUES (?,?,?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertData);

            insertStmt.setString(1, "Aika");
            insertStmt.setInt(2, 31);
            insertStmt.setDouble(3, 95.6);
            insertStmt.executeUpdate();

            //retrieve data
            String selectSQL = "SELECT * FROM students";
            rs = stmt.executeQuery(selectSQL);

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double grade = rs.getDouble("grade");

                System.out.println("ID is " + id);
                System.out.println("Name is " + name);
                System.out.println("Age is " + age);
                System.out.println("Grade is " + grade);
            }

            String updateSQL = "UPDATE students SET grade = 8.7 WHERE id = 1";
            stmt.executeUpdate(updateSQL);

            //close resources

            rs.close();
            insertStmt.close();
            stmt.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();

        }



    }
}
