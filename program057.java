//circular queue using array
//time complexity (add,remove,peek) O(1)
import java.util.*;
public class program057{
    static class Queue{
        static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;  

        @SuppressWarnings("static-access")
        Queue(int n){
            arr = new int[n];
            this.size = n;
        }
        public static boolean isEmpty(){
            //return rear == -1 && front = -1;
            return (rear == -1 && front == -1);
        }
        public static boolean isFull(){
            return ((rear+1) % size) == front;
        }
    
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is Full");
                return;
            }
            if(front == -1){
                front = 0;
            }
            rear = ((rear + 1) % size);
            arr[rear] = data;
        }
    
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty ");
                return -1;
            }
            int result = arr[front];
            if(rear == front){
                rear = front = -1;
            }else{
                front = ((front + 1) % size);
            }
            return result;
        }
    
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty ");
                return -1;
            }
            return arr[front];
        }
    }
    @SuppressWarnings("static-access")
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of a queue : ");
        int a = sc.nextInt();
        Queue q = new Queue(a);
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