//Stack using java collection framework
import java.util.*;
public class program064{   
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of a stack : ");
        int a = sc.nextInt();
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<a;i++){
            System.out.print("Enter element at position "+i+" : ");
            s.push(sc.nextInt());
        }
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