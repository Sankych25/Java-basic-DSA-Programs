//stack using LinkedList
//to run this program first compile with this line -->  javac -Xlint:unchecked program062.java
import java.util.*;
public class program062{
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    static class stack{
        public static Node head;
        public static boolean isEmpty(){
            return head == null;
        }
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of a Stack : ");
        int a = sc.nextInt();
        Stack s = new Stack();
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