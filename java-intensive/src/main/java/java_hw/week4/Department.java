package java_hw.week4;

import java.util.ArrayList;

public class Department {
    public String departmentName;
    public ArrayList<Professor> professors;
    public ArrayList<Course> courses;

    public Department(String departmentName){
        this.departmentName = departmentName;
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addProfessors(Professor pf){
        professors.add(pf);

    }

    public void listProfessors(){
        for(Professor professor : professors){
            System.out.println("Professor " + professor.name + " " + professor.department + " "+ professor.calculateSalary());
        }
    }
}
