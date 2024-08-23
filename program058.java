//queue using linkedlist
//time complexity
import java.util.*;
public class program058{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    } 
    static class Queue{
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return (head == null & tail == null);
        }

        public static void add(int data){
            Node newNode = new Node(data);
            if(tail == null){
                tail = head = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = head.data;
            if(head == tail){
                tail = null;
            }
            head = head.next;
            return front;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
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
        // Queue q = new Queue();
        // q.add(2);
        // q.add(4);
        // q.add(15);
        //system.out.print(q);
        while(!q.isEmpty()){
            System.out.print(q.peek());
            q.remove(); 
            if(!q.isEmpty()){
                System.out.print(" --> ");
            }
        }
    }
    
}