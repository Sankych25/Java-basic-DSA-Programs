//print string in reverse input given by user(recursion)
import java.util.*;
public class program024_1{
    public static void printReverse(String str,int idx){
        if(idx==0){
            System.out.println(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        printReverse(str,idx-1);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to reverse : ");
        String str = sc.next();
        System.out.print("Reverse string is : ");
        printReverse(str,str.length()-1);
        sc.close();
    }
}