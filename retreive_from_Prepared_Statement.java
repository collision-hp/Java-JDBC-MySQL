import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class retreive_from_Prepared_Statement {
    public static void main(String[] args) throws ClassNotFoundException{

        String url="jdbc:mysql://localhost:3306/myDatabase";
        String username="root";
        String password="Sbc@421926";
        String query="select * from employee where name=? and id=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection conn=DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully");
            PreparedStatement preparedstmt=conn.prepareStatement(query);
            preparedstmt.setString(1,"Hitman gill");
            preparedstmt.setInt(2, 5);
            ResultSet result=preparedstmt.executeQuery();
            while(result.next()){//to iterate the data .next because we donot know how many queries are going to be returned
                int id=result.getInt("id");
                String name=result.getString("name");
                String jobTitle=result.getString("job_title");
                int salary=result.getInt("salary");

                System.out.println(id);
                System.out.println(name);
                System.out.println(jobTitle);
                System.out.println(salary);
            }
            result.close();
            preparedstmt.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
