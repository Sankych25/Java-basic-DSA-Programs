// half pyramid number pattern input by the user
import java.util.*;
public class program013{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //System.out.println("Please give dimension of rectangle");
        System.out.print("Number of  rows & columns : ");
        int n=sc.nextInt();
        sc.close();
        //System.out.println("Number of columns :");
        //int m=sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();     
        }
    }   
}
