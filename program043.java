//Find the number of ways in which you can invite n people to your party, single or pair(recursion & backtracking)
//time complexity 
import java.util.*;
public class program043{
    public static int callGuest(int n){
        if(n<=1){
            return 1;
        }
        int way1 = callGuest(n-1);
        int way2 = callGuest(n-2) * (n-1);
        return way1+way2;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of guest you want to invite : ");
        int n =  sc.nextInt();
        System.out.print("Total "+callGuest(n)+" ways are available to invite guest.");
        sc.close();
    }
}