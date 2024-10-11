package java_hw.week2.school.managament;

import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Student>students;

    public CourseManager(){
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

//    public void displayAllStudents(){
//        for( Student student : students){
//            System.out.println("student id is " + student.getStudentID);
//            System.out.println("student name is " + student.name);
//            System.out.println("student age is " + student.getAge);
//        }
//    }
}
