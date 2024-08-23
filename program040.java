//print all combinations of a string(recursion & backtracking)//
//time complexity O(n*n!)
import java.util.*;
public class program040{
    public static void permutationStr(String str,String permutations){
        if(str.length()==0){
            System.out.print(permutations+" ");
            return;
        }
        for(int i=0;i<str.length();i++){
            char currChar = str.charAt(i);
            String newStr = str.substring(0,i)+str.substring(i+1);
            permutationStr(newStr,permutations+currChar);
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str =  sc.next();
        //System.out.print(X+"^"+n+" is : "+calcPower(n,X));
        permutationStr(str,"");
        sc.close();
    }
}