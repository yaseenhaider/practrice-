import java.util.Scanner;
class Student {
    String name;
    String rollnumber;
    String cinic;
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Rollnumber: " + rollnumber);
        System.out.println("Cinic: " + cinic);

    }
}
public class Student {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Yaseen";
        s1.rollnumber = "070";
        s1.cinic = "123";
        s1.display();
    }
}