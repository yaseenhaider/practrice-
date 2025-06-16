
class Person {
    protected String name, address, phone, email;

    Person(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    void display() {
        System.out.println("\n--- Person Details ---");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}


class Student extends Person {
    String status;

    Student(String name, String address, String phone, String email, String status) {
        super(name, address, phone, email);
        this.status = status;
    }

    void display() {
        super.display();
        System.out.println("Status: " + status);
    }
}


class Employee extends Person {
    String office;
    double salary;
    String dateHired;

    Employee(String name, String address, String phone, String email, String office, double salary, String dateHired) {
        super(name, address, phone, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    void display() {
        super.display();
        System.out.println("Office: " + office);
        System.out.println("Salary: $" + salary);
        System.out.println("Date Hired: " + dateHired);
    }
}

class Faculty extends Employee {
    String officeHours, rank;

    Faculty(String name, String address, String phone, String email, String office, double salary, String dateHired, String officeHours, String rank) {
        super(name, address, phone, email, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    void display() {
        super.display();
        System.out.println("Office Hours: " + officeHours);
        System.out.println("Rank: " + rank);
    }
}

// Subclass: Staff (inherits from Employee)
class Staff extends Employee {
    String title;

    Staff(String name, String address, String phone, String email, String office, double salary, String dateHired, String title) {
        super(name, address, phone, email, office, salary, dateHired);
        this.title = title;
    }

    void display() {
        super.display();
        System.out.println("Title: " + title);
    }
}


public class Task1 {
    public static void main(String[] args) {

        Person person = new Person("Yaseen", "123 Street", "123-456", "yaseen@example.com");
        Student student = new Student("Haider", "456 Avenue", "987-654", "haider@example.com", "Sophomore");
        Employee employee = new Employee("Mine", "789 Lane", "555-555", "mine@example.com", "Office 101", 50000, "March 17, 2025");
        Faculty faculty = new Faculty("Dr. Abid", "101 Road", "111-222", "abid@example.com", "Office 202", 80000, "March 17, 2025", "9 AM - 5 PM", "Professor");
        Staff staff = new Staff("Karen", "789 Street", "444-444", "karen@example.com", "Office 303", 40000, "March 17, 2025", "HR Manager");


        person.display();
        student.display();
        employee.display();
        faculty.display();
        staff.display();
    }
}
