package java_hw.week4;

class AdjunctProfessor extends Professor{

    private int coursesTaught;

    public AdjunctProfessor (String name, String department, int coursesTaught){
        super(name, department);
        this.coursesTaught = coursesTaught;
    }

    @Override
    double calculateSalary(){
        return coursesTaught * 1500;
    }
}
