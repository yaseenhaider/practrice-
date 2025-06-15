// Base class for all library users
class LibraryUser {
    protected String userID;
    protected String name;

    // Constructor
    public LibraryUser(String userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    // Method to display user details
    public void displayDetails() {
        System.out.println("User ID: " + userID);
        System.out.println("Name: " + name);
    }
}

// Derived class for Librarian
class Librarian extends LibraryUser {
    private String employeeID;

    public Librarian(String userID, String name, String employeeID) {
        super(userID, name);
        this.employeeID = employeeID;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Employee ID: " + employeeID);
    }
}

// Derived class for Member
class Member extends LibraryUser {
    private String membershipID;

    public Member(String userID, String name, String membershipID) {
        super(userID, name);
        this.membershipID = membershipID;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Membership ID: " + membershipID);
    }
}

// Derived class for Guest
class Guest extends LibraryUser {
    public Guest(String userID, String name) {
        super(userID, name);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Visit Purpose: Browsing");
    }
}

// Example usage
public class LibrarySystem {
    public static void main(String[] args) {
        Librarian librarian = new Librarian("L001", "Alice", "E123");
        Member member = new Member("M001", "Bob", "M456");
        Guest guest = new Guest("G001", "Charlie");

        librarian.displayDetails();
        System.out.println();
        member.displayDetails();
        System.out.println();
        guest.displayDetails();
    }
}