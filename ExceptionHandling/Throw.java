package ExceptionHandling;
import java.util.*;
public class Throw {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int age=sc.nextInt();
        if(age<10){
            throw new RuntimeException("Sorry you are not eligible");
        }
        else{
            System.out.println("Eligible");
        }
    }
}
