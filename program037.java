//Print keypad combinations(recursion)
//time complexity 
import java.util.*;
public class program037{
    public static String[] keypad={".","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void printCombinations(String str,int idx,String combinations){
        if(idx==str.length()){
            System.out.println(combinations);
            return;
        }
        char currChar = str.charAt(idx);
        String mapping = keypad[currChar-'0'];
        for(int i=0;i<mapping.length();i++){
            printCombinations(str,idx+1,combinations+mapping.charAt(i));
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Press keys of a keypad : ");
        String str = sc.next();
        sc.close();
        printCombinations(str,0,"");
    }
}