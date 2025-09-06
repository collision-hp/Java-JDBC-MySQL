package ExceptionHandling;

public class Throws {
    public static void division(int dividend,int divisor) throws ArithmeticException{
        System.out.println("The result is "+dividend/divisor);

    }
    public static void main(String[] args){
        try{
            division(10, 0);
        }
        catch(ArithmeticException e){
            System.out.println("Cannot divide by zero "+e.getMessage());
        }
    }
}
