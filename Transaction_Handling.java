import java.sql.*;
import java.util.*;

public class Transaction_Handling {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/myDatabase";
        String username = "root";
        String password = "Sbc@421926";
        String withdrawquery = "update accounts set balance=balance-? where accno=?;";
        String depositquery = "update accounts set balance=balance+? where accno=?;";
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
            try {
                PreparedStatement withdraw = conn.prepareStatement(withdrawquery);
                PreparedStatement deposit = conn.prepareStatement(depositquery);

                withdraw.setDouble(1, 500.00);
                withdraw.setString(2, "acc123");

                deposit.setDouble(1, 500.00);
                deposit.setString(2, "acc321");

                int rowsaffectedwithdraw=withdraw.executeUpdate();
                int rowsaffecteddeposit=deposit.executeUpdate();
                if(rowsaffecteddeposit>0 && rowsaffectedwithdraw>0){
                    conn.commit();
                    System.out.println("Transaction Successful");
                }
                else{
                    conn.rollback();
                    System.out.println("Transaction Failed");
                }


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

    }
}
