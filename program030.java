//Tower of honoi
//S : source
//D : destination
//H : helper
import java.util.*;
public class program030{
    public static void towerOfHonoi(int n,String src,String helper,String dest){
        //count++;
        if(n==1){
            System.out.println("Transfer disc "+n+" from "+src+" to "+dest); 
            
           // System.out.println("Number of steps requirds to move all disc from S to D is :"+count);
            //count = count+1;
            return;
        }
        towerOfHonoi(n-1,src,dest,helper);
        System.out.println("Transfer disc "+n+" from "+src+" to "+dest);
        //count = count+1;
        towerOfHonoi(n-1,helper,src,dest);
        //return count;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of disc : ");
        int n =sc.nextInt();
        towerOfHonoi(n,"S","H","D");
        sc.close();
    }
}
