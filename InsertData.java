import java.sql.*;

public class InsertData {
    public static void main(String[] args) throws ClassNotFoundException{

        String url="jdbc:mysql://localhost:3306/myDatabase";
        String username="root";
        String password="Sbc@421926";
        String query="insert into employee values(5,'Hitman gill','Analyst',79000.0);";
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
            //to delete a data
            int rowsAffected=stmt.executeUpdate(query);
            //to retreive data
            // ResultSet rs=stmt.executeQuery(query);
            

            if(rowsAffected>0){
                System.out.println(rowsAffected +" rows affected!! \nDeletion Successful");
            }
            else{
                System.out.println("Deletion Failed");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
