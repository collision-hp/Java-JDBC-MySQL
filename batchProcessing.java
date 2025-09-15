import java.sql.*;
import java.util.Scanner;

public class batchProcessing {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/myDatabase";
        String username = "root";
        String password = "Sbc@421926";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully");
            conn.setAutoCommit(false);// it should be manually commited
            // Statement statement = conn.createStatement();
            // statement.addBatch(
            //         "insert into employee(id,name,job_title,salary) values (9,'Hardik','HR Manager',6777777.0);");
            // statement.addBatch(
            //         "insert into employee(id,name,job_title,salary) values (10,'Pandya','Project Manager',699999.0);");
            // statement.addBatch(
            //         "insert into employee(id,name,job_title,salary) values (11,'Krunal','Sales Manager',67777.0);");

            // int batchresult[] = statement.executeBatch();
            // conn.commit();
            // System.out.println("Batch Executed Successfully");

            //Using Prepared Statement
            String query="insert into employee values(?,?,?,?);";
            PreparedStatement prepstatement=conn.prepareStatement(query);
            Scanner sc= new Scanner(System.in);
            while(true){
                System.out.println("Enter your id");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.println("Name");
                String name=sc.nextLine();
                System.out.println("Job_Tile");
                String job_title=sc.nextLine();
                System.out.println("Salary");
                double salary=sc.nextDouble();
                prepstatement.setInt(1, id);
                prepstatement.setString(2, name);
                prepstatement.setString(3, job_title);
                prepstatement.setDouble(4, salary);
                sc.nextLine();
                prepstatement.addBatch();
                System.out.println("ADD MORE VALUES-> Y/N");
                String action=sc.nextLine();
                if(action.toLowerCase().equals("Y")){
                    continue;
                }
                else{
                    break;
                }
            }
            int batchresult[] = prepstatement.executeBatch();
            conn.commit();
            System.out.println("Batch Executed Successfully");


        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }
}