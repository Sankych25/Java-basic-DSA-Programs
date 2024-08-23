//write a code to reverse a linked List(collection framework method)
import java.util.*;
public class program068_2{
    @SuppressWarnings("resource")
    public static void main(String args[]){
        LinkedList<Integer> list1 = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many element you want to add ? : ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter element at position "+i+" :");
            list1.add(sc.nextInt());
        }
        System.out.println("Your linledlist is : "+list1);
        Collections.reverse(list1);
        System.out.println("reverse linkedlist is : "+list1);
    }
}
