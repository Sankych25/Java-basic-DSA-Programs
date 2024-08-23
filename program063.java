//Stack using arrayList
import java.util.*;
public class program063{
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
            return list.size() == 0;
        }

        public static void push(int data){
            list.add(data);
        }

        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    @SuppressWarnings("static-access")
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of a stack : ");
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