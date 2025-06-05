
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = App2.getConnection();
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM student");

                while (rs.next()) {

                    System.out.println("Name: " + rs.getString("name"));


                }

                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
