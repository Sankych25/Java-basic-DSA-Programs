//First and last occurance of an element in string(recursion)
//Time complexity O(n)
import java.util.*;
public class program031{
    public static int first = -1;
    public static int last = 1;
    public static void findOccurance(String str,int idx,char element){
        if(idx==str.length()){
            System.out.println("First occurance of a character "+element+" is at position : "+first);
            System.out.println("Last occurance of a character "+element+" is at position : "+last);
            return;
        }
        char currChar = str.charAt(idx);
        if(currChar==element){
            if(first==-1){
                first = idx;
            }else{
                last = idx;
            }
        }
        findOccurance(str,idx+1,element);
        //System.out.print(str.charAt(idx));
        //printReverse(str,idx-1);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("for ex : aabfvaabgdffdgvsvbdg");
        System.out.print("Enter a string  : ");
        String str = sc.next();
        System.out.print("Enter a character for finding occurance  : ");
        char character = sc.next().charAt(0);
        //char character = 'e';
        findOccurance(str,0,character);
        sc.close();
    }
}