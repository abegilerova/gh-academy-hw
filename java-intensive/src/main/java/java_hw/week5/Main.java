package java_hw.week5;

import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        try {
            System.out.println("Enter student name ");
            String studentName = myObj.nextLine();
            System.out.println("Student name is: " + studentName);

            if(studentName == null && studentName.trim().isEmpty()) {
                throw new InvalidNameException("Name cannot be null or empty " + studentName);
            }

            System.out.println("Enter student age ");
            String studentAge = myObj.nextLine();
            System.out.println("Student age is: " + studentAge);

            if(Integer.parseInt(studentAge) < 18 && Integer.parseInt(studentAge) > 60){
                throw new InvalidAgeException("Age cannot be less than 18 and more than 60 " + Integer.parseInt(studentAge));
            }

            Student student1 = new Student(studentName, Integer.parseInt(studentAge));

            CourseRegistration cr = new CourseRegistration();
            cr.registerStudent(student1);

        }catch (InvalidNameException e){
            System.out.println(e.getMessage());
        } catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        }

    }
}
