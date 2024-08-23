//move all "X" to the end of the string(recursion)
import java.util.*;
public class program033{
    public static void moveAllX(String str,int idx,int count,String newString,char x){
        if(idx==str.length()){
            for(int i=0;i<count;i++){
                newString += x;
            }
            System.out.println("Output : "+newString);
            return;
        }
        char currChar = str.charAt(idx);
        if(currChar==x){
            count++;
            moveAllX(str,idx+1,count,newString,x);
        }else{
            newString += currChar;
            moveAllX(str,idx+1,count,newString,x);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.next();
        System.out.print("Enter a character which move at the end : ");
        char x = sc.next().charAt(0);
        sc.close();
        moveAllX(str,0,0,"",x);
    }
}