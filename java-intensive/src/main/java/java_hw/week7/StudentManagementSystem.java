package java_hw.week7;

import java.io.IOException;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main (String [] args){
        String filePath = "students.txt";
        StudentManager studentManager = new StudentManager(filePath);
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            try{
                switch(choice){
                    case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter name: ");
                    String name = scanner.next();
//                    System.out.print("Enter age: ");
//                    int age = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();

                    Student newStudent = new Student(id, name, grade);
                    studentManager.addStudent(newStudent);
                    System.out.println("Student added successfully ");

                    case 2:
                        studentManager.displayStudents();
                        break;
                }
            }catch(IOException e){
                System.err.println(("Error managing students: " + e.getMessage()));

            }
        }
    }
}
