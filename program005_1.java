//Print number from 0 to n using do while loop.
 import java.util.*;
 class program005_1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value for n : ");
        int n=sc.nextInt();
       // int b=sc.nextInt();
        int i=0;
        do{
            System.out.print(i+" ");
            i++;
        }while(i<=n);
        sc.close();
       // System.out.println(a+b);
    }
}