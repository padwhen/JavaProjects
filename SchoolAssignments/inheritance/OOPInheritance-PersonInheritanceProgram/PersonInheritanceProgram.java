class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

class Student extends Person {
    private int credits;
    public Student(String name) {
        super(name);
        this.credits = 0;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public String toString() {
        return "Student: " + super.toString() + ", " + credits + " credits";
    }
    public void completeCourse() {
        this.credits += 5;
    }
}

class Teacher extends Person {
    private double salary;
    public Teacher(String name, double salary) {
        super(name);
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String toString() {
        return "Teacher: " + super.toString() + ", salary is " + salary;
    }
}

public class PersonInheritanceProgram {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Chris Date", 3000);
        Teacher teacher2 = new Teacher("Joe Satriani", 5000);
        Student student = new Student("Steve Vai");
        System.out.println(teacher1);
        System.out.println(teacher2);
        System.out.println(student);
        student.completeCourse();
        student.completeCourse();
        System.out.println("---");
        System.out.println(student);
    }
}
