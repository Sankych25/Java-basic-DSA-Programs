// palindromic pyramid pattern input by the user
import java.util.*;
public class program020{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //System.out.println("Please give dimension of rectangle");
        System.out.print("Number of  rows & columns : ");
        int n=sc.nextInt();
        sc.close();
        //System.out.println("Number of columns :");
        //int m=sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j+" ");
            }
            for(int j=2;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
           
           

