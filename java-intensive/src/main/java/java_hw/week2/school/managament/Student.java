package java_hw.week2.school.managament;

import java_hw.week2.school.Person;

import java.util.List;

public class Student extends Person {

    private int studentID;
    private List <String> enrolledCourses;

    public double getTuition() {
        return tuition;
    }

    public void setTuition() {
        this.tuition = enrolledCourses.size() * 500;
    }

    private double tuition;

    public Student(int studentID, String name, int age) {
        super(name, age);
        this.studentID = studentID;
    }

    public void enrollCourses(List<String>enrolledCourses){
        this.enrolledCourses = enrolledCourses;
    }

    public void enrollCourses(String enrolledCourse){
        this.enrolledCourses.add(enrolledCourse);
    }

    public int getStudentID(){
        return studentID;
    }
}
