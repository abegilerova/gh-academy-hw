package java_hw.week5;

import java.util.ArrayList;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

public class CourseRegistration {
    public ArrayList<Student> students;

    public CourseRegistration(){
        students = new ArrayList<>();
    }

    public void registerStudent(Student student) throws CourseFullException {
            if(students.size() >5 ){
                throw new CourseFullException("Cannot add more than 5 students ");
            }

            students.add(student);
    }

    public int getStudentsSize(){
        return students.size();
    }
}
