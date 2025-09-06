package ExceptionHandling;
import java.util.*;
public class MultipleExceptionHandling {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[5];
        try{
            arr[6]=10/0;
        }

        // catch(ArrayIndexOutOfBoundsException e){
        //     System.out.println(e.getMessage());
        // }
        // catch(ArithmeticException e){
        //     System.out.println(e.getMessage());
        // }
        // the arithmeticException will show first because after the operation is performed then only the element can be added to the index 6
        catch(ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}
