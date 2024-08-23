//Addition of two numbers input given by user
import java.util.*;
public class program002{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Addition of two numbers");
        System.out.print("Enter first number : ");
        int a=sc.nextInt();
        System.out.print("Enter second number : ");
        int b=sc.nextInt();
        int sum= a+b;
        System.out.println(a+" + "+b+" = "+sum);
        sc.close();
    }
}