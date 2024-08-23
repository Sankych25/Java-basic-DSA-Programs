//remove duplicate characters from a string(recursion)
//time complexity O(n)
import java.util.*;
public class program034{
    public static boolean[] map = new boolean[26];
    public static void removeDuplicates(String str,int idx,String newString){
        if(idx==str.length()){
            System.out.println("Output : "+newString);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a']){
            removeDuplicates(str,idx+1,newString);
        }else{
            newString += currChar;
            map[currChar-'a'] = true;
            removeDuplicates(str,idx+1,newString);
        }
    }
    public static void main(String args[]){
        //String str = "axbcxxdxx";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.next();
        sc.close();
        removeDuplicates(str,0,"");
    }
}