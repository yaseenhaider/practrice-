// Patient.java
 class Patient {
    // Private data members (encapsulation hides them from direct access)
    private String name;
    private int age;
    private String disease;

    // Constructor
    public Patient(String name, int age, String disease) {
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }

    // Getter for disease
    public String getDisease() {
        return disease;
    }

    // Setter for disease
    public void setDisease(String disease) {
        this.disease = disease;
    }

    // Method to display details
    public void displayInfo() {
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
    }
}
// Main.java
public class Fkhan {
    public static void main(String[] args) {
        // Creating a patient object
        Patient p1 = new Patient("John", 30, "Fever");

        // Accessing data using getters
       // System.out.println("Name: " + p1.getName());

        // Modifying data using setters
        p1.setAge(35);
        p1.setDisease("Flu");
        p1.setName("noor");

        // Displaying full info
        p1.displayInfo();
    }
}
