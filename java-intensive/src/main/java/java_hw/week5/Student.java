package java_hw.week5;


class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Student {
    public String name;
    public int age;

    public  Student (String name, int age){
        try {
            this.name = name;
            this.age = age;

            if(name == null && name.trim().isEmpty()) {
                throw new InvalidNameException("Name cannot be null or empty " + name);
            }
            if(age < 18 && age > 60){
                System.out.println("age is " + age);
                throw new InvalidAgeException("Age cannot be less than 18 and more than 60 " + age);
            }

        }catch (InvalidNameException e){
            System.err.println(e.getMessage());
        } catch (InvalidAgeException e){
            System.err.println(e.getMessage());
        }
    }
}
