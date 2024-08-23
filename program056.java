//queue using array(add,remove,peek function)
//add O(1)
//remove O(n)
//peek O(n)
import java.util.*;
public class program056{
    static class Queue{
        static int arr[];
        static int size;
        static int rear = -1;   

        @SuppressWarnings("static-access")
        Queue(int n){
            arr = new int[n];
            this.size = n;
        }
        public static boolean isEmpty(){
            return rear == -1;
        }
    
        public static void add(int data){
            if(rear == size-1){
                System.out.println("Queue is Full");
                return;
            }
            rear++;
            arr[rear] = data;
        }
    
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty ");
                return -1;
            }
            int front = arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return front;
        }
    
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty ");
                return -1;
            }
            return arr[0];
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