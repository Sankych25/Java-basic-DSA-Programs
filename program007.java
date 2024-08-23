// print table of a number input by the user
 import java.util.*;
 public class program007{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Which number`s table you want : ");
        int n=sc.nextInt();
        sc.close();
        System.out.println("Table of a "+n+" number is :");
        for(int i=1;i<11;i++){
            System.out.println(i * n);
        }   
     }
}