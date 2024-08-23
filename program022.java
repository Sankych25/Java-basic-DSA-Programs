// Print factorial of a given number
import java.util.*;
public class program022{
    public static void fact(int n){
        int factorial=1;
        for(int i=1;i<=n;i++){
            factorial=factorial*i;
        }
        System.out.println("Factorial of "+n+" is : "+factorial);
        return;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int n=sc.nextInt();
        sc.close();
        fact(n);
    }
}