//queue using ArrayDequeue
//time complexity
import java.util.*;
public class program060{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of a queue : ");
        int a = sc.nextInt();
        Queue<Integer> q = new ArrayDeque<>();
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