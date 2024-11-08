package java_hw.week8;

import java.sql.*;

public class Students {

    private static final String URL = "/Users/aikanysh/growthhungry/gh-academy-hw/java-intensive/src/main/java/java_hw/week8/students.db";

    public static void main (String [] args )  {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Students studentsApp = new Students();

        try {
            conn = DriverManager.getConnection(URL);
            stmt = conn.createStatement();
        } catch(SQLException e) {
            e.printStackTrace();

        }



    }
}
