//Print numbers from 0  to n using for loop.
 import java.util.*;
 class program004{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value for n : ");
        int n=sc.nextInt();
        //int b=sc.nextInt();
        for(int i=0;i<=n;i++){
            System.out.print(i+" ");
        }
       // System.out.println(a+b);
       sc.close();
    }
}