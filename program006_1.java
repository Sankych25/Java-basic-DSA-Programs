//print sum of first n natural numbers(recursion)
//time complexity 
import java.util.*;
public class program006_1{
    public static void sumOfNumbers(int n,int idx,int sum){
        if(idx>n){
            System.out.println(sum);
            return;
        }
        sum += idx;
        sumOfNumbers(n,idx+1,sum);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value for n : ");
        int n=sc.nextInt();
        //int n = 5;
        System.out.print("sum of first "+n+" natural number is : ");
        sumOfNumbers(n,1,0);
        sc.close();
    }
}