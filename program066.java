//Write a code to Reverse  stack
import java.util.*;
public class program066{
    public static void pushAtBottom(int data,Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(data,s);
        s.push(top);
    }
    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverse(s);
        pushAtBottom(top,s);
    }
    public static void main(String args[]){
        //Stack<Integer> s = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of a stack : ");
        int a = sc.nextInt();
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<a;i++){
            System.out.print("Enter element at position "+i+" : ");
            s.push(sc.nextInt());
        }
        reverse(s);
        // System.out.print("Enter element which you want to push at bottom : ");
        // pushAtBottom(sc.nextInt(),s);
        sc.close();
        while(!s.isEmpty()){
            System.out.print(s.peek());
            s.pop(); 
            if(!s.isEmpty()){
                System.out.print(" --> ");
            }
        }
    }
}