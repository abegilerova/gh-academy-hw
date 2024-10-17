package java_hw.week4;

abstract class Professor {
    public String name;
//    public Double salary;
    public String department;

    public Professor(String name, String department){
        this.name = name;
        this.department = department;
    }

    public void teachCourse(){
        System.out.println(name + " is teaching in the " + department + " department.");
    }

   abstract double calculateSalary();
}
