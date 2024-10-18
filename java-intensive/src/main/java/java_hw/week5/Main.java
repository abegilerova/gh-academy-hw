package java_hw.week5;

import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter student name ");

        String studentName = myObj.nextLine();  // Read user input
        System.out.println("Student name is: " + studentName);  // Output user input

        System.out.println("Enter student age ");
        String studentAge = myObj.nextLine();
        System.out.println("Student age is: " + studentAge);

        Student student1 = new Student(studentName, Integer.parseInt(studentAge));
        CourseRegistration cr = new CourseRegistration();
        cr.registerStudent(student1);

    }
}
