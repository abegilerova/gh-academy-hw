package java_hw.week7;

public class Student {
    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;
    private double grade;

    public Student (int id, String name, double grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString(){
        return "Id is " + id + ", Name is " + name + ", Grade is " + grade;
    }

    public static Student fromString (String data) {
        String [] studentFields = data.split(",");
        int id = Integer.parseInt(studentFields[0]);
        String name = studentFields[1];
        double grade = Double.parseDouble(studentFields[2]);
        return new Student(id, name, grade);

    }
}
