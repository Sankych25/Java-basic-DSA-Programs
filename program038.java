//print fibonacci series upto n th term(recursion)
//time complexity 
import java.util.*;
public class program038{
    public static void fibonacciSeries(int n,int a,int b){
        if(n==0){
            //.out.println("1");
            return;
        }
        int c = a + b;
        System.out.print(c+" ");
        fibonacciSeries(n-1,b,c);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value for n : ");
        int n=sc.nextInt();
        //int n = 5;
        System.out.print("Fibonacci series upto "+n+" th term : 0 1 ");
        fibonacciSeries(n-2,0,1);
        sc.close();
    }
}