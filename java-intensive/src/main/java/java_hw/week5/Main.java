package java_hw.week5;

import java.util.Scanner;

public class Main {
    public static void main (String [] args) {
        Scanner myObj = new Scanner(System.in);// Create a Scanner object
        CourseRegistration cr = new CourseRegistration();

        while (cr.getStudentsSize() < 5) {
         System.out.println("Enter student name ");
         String studentName = myObj.nextLine();
         System.out.println("Student name is: " + studentName);

         System.out.println("Enter student age ");
         int studentAge = myObj.nextInt();
         System.out.println("Student age is: " + studentAge);

        try {
            Student st = new Student(studentName, studentAge);
            cr.registerStudent(st);
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CourseFullException e) {
            System.out.println(e.getMessage());
            break;
        }
    }

        System.out.println("Registration process completed");
        myObj.close();

    }
}
