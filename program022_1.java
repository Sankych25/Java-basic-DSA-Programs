//print sum of first n natural numbers(recursion)
//time complexity 
import java.util.*;
public class program022_1{
    public static void factorial(int n,int fact){
        if(n==0||n==1){
            System.out.println(fact);
            return;
        }
        fact = fact * n;
        factorial(n-1,fact);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value for n : ");
        int n=sc.nextInt();
        sc.close();
        //int n = 5;
        System.out.print("Factorial of "+n+" is : ");
        factorial(n,1);
        sc.close();
    }
}