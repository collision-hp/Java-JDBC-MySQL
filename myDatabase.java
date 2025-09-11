
import java.sql.*;
public class myDatabase {
    public static void main(String[] args) throws ClassNotFoundException{

        String url="jdbc:mysql://localhost:3306/myDatabase";
        String username="root";
        String password="Sbc@421926";
        String query="select * from employee";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection conn=DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            //data retrieval
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String jobtitle=rs.getString("job_title");
                double salary=rs.getDouble("salary");
                System.out.println("--------------------------------------");
                System.out.println("ID "+id);
                System.out.println("Name "+name);
                System.out.println("Job Title "+jobtitle);
                System.out.println("Salary "+salary);
            }

            rs.close();
            stmt.close();
            System.out.println("Connection Terminated");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
