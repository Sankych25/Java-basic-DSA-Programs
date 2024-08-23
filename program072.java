//ArrayList basic function
import java.util.*;
public class program072{
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many number you want to add : ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter element at position "+i+" : ");
            list.add(sc.nextInt());
        }
        list.remove(1);
        list.set(0,6);
        //int size = list.size();
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.print("Sorted list is : ");
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        sc.close();
    }
}