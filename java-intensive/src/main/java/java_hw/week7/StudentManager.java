package java_hw.week7;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    public String filePath;

    public StudentManager(String filePath){
        this.filePath = filePath;
    }

   public void saveStudentsToFile ( List<Student> students) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for(Student st : students){
                writer.write(st.toString());
                writer.newLine();
            }
        }
   }

   public void addStudent(Student student) throws IOException {
        List<Student> students = readAndLoadStudents();
        students.add(student);
        saveStudentsToFile(students);
   }

   private List<Student> readAndLoadStudents() throws IOException{
        List<Student> students = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                students.add(Student.fromString(line));
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found. Starting fresh");

        }

        return students;
   }

   public void displayStudents() throws IOException {
        List<Student> students = readAndLoadStudents();
        if(students.isEmpty()){
            System.out.println("No students are added");
        }
        for (Student student : students){
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() +
                    ", Grade: " + student.getGrade());
        }
   }

    public void updateGrade(int id, double newGrade) throws IOException {
        List<Student> students = readAndLoadStudents();
        boolean found = false;
        for (Student student : students){
           if (student.getId() == id){
               student.setGrade(newGrade);
               found = true;
               break;
           }
        }

        if(found){
            saveStudentsToFile(students);
            System.out.println("Students are updated successfully.");
        } else{
            System.out.println("Student with ID " + id + " not found.");
        }

    }
}
