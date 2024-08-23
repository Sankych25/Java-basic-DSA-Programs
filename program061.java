//Queue using 2 stack
import java.util.*;
public class program061{
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }       

        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty !!");
                return -1;
            }
            return s1.pop();
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty !!");
                return -1;
            }
            return s1.peek();
        }
    }
    @SuppressWarnings("static-access")
    public static void main(String args[]){
         Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of a queue : ");
        int a = sc.nextInt();
        Queue q = new Queue();
        for(int i=0;i<a;i++){
            System.out.print("Enter element at position "+i+" : ");
            q.add(sc.nextInt());
        }
        sc.close();
        while(!q.isEmpty()){
            System.out.print(q.peek());
            q.remove(); 
            if(!q.isEmpty()){
                System.out.print(" --> ");
            }
        }
    }
}