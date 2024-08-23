//Print number from 0 to n using while loop.
 import java.util.*;
 class program005{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value for n : ");
        int n=sc.nextInt();
        //int b=sc.nextInt();
        int i=0;
        while(i<=n){
            System.out.print(i+" ");
            i++;
        }
        sc.close();
       // System.out.println(a+b);
    }
}