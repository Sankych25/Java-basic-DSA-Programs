//print X^n(recursion)(stack hight log n)
//time complexity 
import java.util.*;
public class program039_1{
    public static int calcPower(int n,int x){
        if(n==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
        if(n%2==0){
            return calcPower(n/2,x)*calcPower(n/2,x);
        }else{
            return calcPower(n/2,x)*calcPower(n/2,x)*x; 
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value for X : ");
        int X =  sc.nextInt();
        System.out.print("Enter value for n : ");
        int n = sc.nextInt();
        System.out.print(X+"^"+n+" is : "+calcPower(n,X));
        sc.close();
    }
}