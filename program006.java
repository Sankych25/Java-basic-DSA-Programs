// print sum of first n natural numbers
 import java.util.*;
 public class program006{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value for n : ");
        int n=sc.nextInt();
        sc.close();
        int sum=0;
        for(int i=0;i<=n;i++){
            sum=sum+i;
        }   
        System.out.println("Sum of first "+n+" natural number is "+sum);
     }
}