package java_hw.week4;

public class FullTimeProfessor extends Professor{

    public double fixedMonthlyAmount;

    public FullTimeProfessor (String name, String department, int fixedMonthlyAmount){
        super(name, department);
        this.fixedMonthlyAmount = fixedMonthlyAmount;
    }

    @Override
    double calculateSalary(){
        return fixedMonthlyAmount;
    }
}

