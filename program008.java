// Rectangle * pattern input by the user
 import java.util.*;
 public class program008{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please give dimension of rectangle");
        System.out.print("Number of rows : ");
        int n=sc.nextInt();
        System.out.print("Number of columns : ");
        int m=sc.nextInt();
        sc.close();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
            System.out.print("* ");
            }
            System.out.println();
        }   
     }
}