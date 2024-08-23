//Get input from user as string and reverse it.
import java.util.*;
public class program024{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string to reverse : ");
        String name=sc.next();
        StringBuilder sb= new StringBuilder(name);
        for(int i=0;i<sb.length()/2;i++){
            int front = i;
            int back = sb.length()-1-i;
            char frontChar = sb.charAt(front);
            char backChar = sb.charAt(back);
            sb.setCharAt(front,backChar);
            sb.setCharAt(back,frontChar);
        }
        System.out.println("Reverse string is : "+sb);  
        sc.close();      
    }
}