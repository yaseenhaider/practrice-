import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App2 {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db"; // Replace 'college' with your DB name
    private static final String USER = "Haider"; // Replace with your MySQL username
    private static final String PASSWORD = "Haider@789"; // Replace with your MySQL password

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to database.");
            e.printStackTrace();
        }
        return conn;
    }
}
