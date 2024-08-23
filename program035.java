//Print all the subsequences of a string(recursion)
//time complexity O(n^2)
import java.util.*;
public class program035{
    public static void subsequences(String str,int idx,String newString){
        if(idx==str.length()){
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(idx);
        subsequences(str,idx+1,newString+currChar);
        subsequences(str,idx+1,newString);     
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.next();
        sc.close();
        subsequences(str,0,"");
    }
}