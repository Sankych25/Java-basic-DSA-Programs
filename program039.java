//print X^n(recursion)(stack hight n)
//time complexity 
import java.util.*;
public class program039{
    public static int calcPower(int n,int x){
        if(n==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
        int xPower1 = calcPower(n-1,x);
        int xPower = x * xPower1;
        return xPower;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value for X : ");
        int X =  sc.nextInt();
        System.out.print("Enter value for n : ");
        int n = sc.nextInt();
        //int n = 5;
        //int ans = calcPower(n,X);
        //System.out.print(ans);
        System.out.print(X+"^"+n+" is : "+calcPower(n,X));
        sc.close();
    }
}