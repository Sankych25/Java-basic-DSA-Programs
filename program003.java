//Get input from user as a string and print it.
import java.util.*;
class program003{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string : ");
        String name=sc.next();
        System.out.println(name);
        sc.close();
    }
}