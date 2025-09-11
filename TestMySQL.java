

import java.sql.*;

public class TestMySQL {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // your DB
        String user = "root"; // MySQL username
        String password = "Sbc@421926"; // MySQL root password

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL!");
            
            // Query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees"); // enter your table name

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("role"));
            }

            // Close
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
