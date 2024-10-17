package java_hw.week4;

public class UniversitySystem {
    public static void main(String [] args){
        // Create departments
        Department dp = new Department("Computer science");

        FullTimeProfessor fp = new FullTimeProfessor("John Smith", "Computer Science", 1000);
        AdjunctProfessor ap = new AdjunctProfessor("Jane Smith", "Computer Science", 5);

        dp.addProfessors(fp);
        dp.addProfessors(ap);

        dp.listProfessors();

    }
}
