import java.util.*;
import java.sql.*;

public class insert_into_PreparedStatement {
    public static void main(String[] args) throws ClassNotFoundException{

        String url="jdbc:mysql://localhost:3306/myDatabase";
        String username="root";
        String password="Sbc@421926";
        String query="insert into employee values(?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection conn=DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Credentials");
            int id=sc.nextInt();
            sc.nextLine();// java.util.InputMismatchException will come if you mix integer with string 
            String name=sc.nextLine();
            String jobtitle=sc.nextLine();
            double salary=sc.nextDouble();
            PreparedStatement preparedstmt=conn.prepareStatement(query);
            preparedstmt.setInt(1, id);
            preparedstmt.setString(2,name);
            preparedstmt.setString(3,jobtitle);
            preparedstmt.setDouble(4, salary);
            int rowsAffected=preparedstmt.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Data Inserted successfuly");
            }
            else{
                System.out.println("Data Insertion failed");
            }
            preparedstmt.close();
            sc.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
