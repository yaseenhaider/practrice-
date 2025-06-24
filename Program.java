import java.sql.*;
import java.util.Scanner;

 class CourseManagement {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "root";
    static final String PASS = "your_password";

    static Connection conn;
    static Scanner sc = new Scanner(System.in);
    static int studentId = 1; // Simulate login

    public static void main(String[] args) throws Exception {
        conn = DriverManager.getConnection(URL, USER, PASS);
        while (true) {
            System.out.println("\n==== Course Menu ====");
            System.out.println("1. View Available Courses");
            System.out.println("2. Enroll in a Course");
            System.out.println("3. View Enrolled Courses");
            System.out.println("4. Drop a Course");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> viewAvailableCourses();
                case 2 -> enrollInCourse();
                case 3 -> viewEnrolledCourses();
                case 4 -> dropCourse();
                case 5 -> {
                    System.out.println("Session ended.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void viewAvailableCourses() throws SQLException {
        String sql = "SELECT * FROM Course WHERE seats_available > 0";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\nAvailable Courses:");
        while (rs.next()) {
            System.out.printf("ID: %d | Name: %s | Seats: %d%n",
                    rs.getInt("course_id"),
                    rs.getString("course_name"),
                    rs.getInt("seats_available"));
        }
    }

    static void enrollInCourse() throws SQLException {
        System.out.print("Enter Course ID to enroll: ");
        int courseId = sc.nextInt();

        String checkSeats = "SELECT seats_available FROM Course WHERE course_id = ?";
        PreparedStatement pst = conn.prepareStatement(checkSeats);
        pst.setInt(1, courseId);
        ResultSet rs = pst.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            // Insert into enrollment
            String enroll = "INSERT INTO Enrollment (student_id, course_id) VALUES (?, ?)";
            pst = conn.prepareStatement(enroll);
            pst.setInt(1, studentId);
            pst.setInt(2, courseId);
            pst.executeUpdate();

            // Reduce seat
            String updateSeats = "UPDATE Course SET seats_available = seats_available - 1 WHERE course_id = ?";
            pst = conn.prepareStatement(updateSeats);
            pst.setInt(1, courseId);
            pst.executeUpdate();

            System.out.println("Enrolled successfully!");
        } else {
            System.out.println("No seats available or invalid course.");
        }
    }

    static void viewEnrolledCourses() throws SQLException {
        String sql = """
            SELECT c.course_id, c.course_name
            FROM Enrollment e
            JOIN Course c ON e.course_id = c.course_id
            WHERE e.student_id = ?
            """;
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, studentId);
        ResultSet rs = pst.executeQuery();

        System.out.println("\nEnrolled Courses:");
        while (rs.next()) {
            System.out.printf("ID: %d | Name: %s%n",
                    rs.getInt("course_id"),
                    rs.getString("course_name"));
        }
    }

    static void dropCourse() throws SQLException {
        System.out.print("Enter Course ID to drop: ");
        int courseId = sc.nextInt();

        String delete = "DELETE FROM Enrollment WHERE student_id = ? AND course_id = ?";
        PreparedStatement pst = conn.prepareStatement(delete);
        pst.setInt(1, studentId);
        pst.setInt(2, courseId);
        int rows = pst.executeUpdate();

        if (rows > 0) {
            String updateSeats = "UPDATE Course SET seats_available = seats_available + 1 WHERE course_id = ?";
            pst = conn.prepareStatement(updateSeats);
            pst.setInt(1, courseId);
            pst.executeUpdate();
            System.out.println("Course dropped successfully.");
        } else {
            System.out.println("Not enrolled in that course.");
        }
    }
}
