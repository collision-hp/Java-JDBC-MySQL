package ExceptionHandling;

import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[5];
        try{
            System.out.println("I am the first block");
            try{
                arr[6]=10;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("This code block is executed at any condition");
        }
        
    }
}
