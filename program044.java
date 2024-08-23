//Print all the subset of first n natural numbers(recursion & backtracking)
//time complexity
import java.util.*;
public class program044{
    public static void printSubset(ArrayList<Integer>subset){
        for(int i=0;i<subset.size();i++){
            System.out.print(subset.get(i)+" ");
        }
        System.out.println();
    }
    public static void findSubset(int n,ArrayList<Integer>subset){
        if(n==0){
            printSubset(subset);
            return;
        }
        subset.add(n);
        findSubset(n-1,subset);
        subset.remove(subset.size()-1);
        findSubset(n-1,subset);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value for n : ");
        int n = sc.nextInt();
        sc.close();
        ArrayList<Integer>subset = new ArrayList<>();
        findSubset(n,subset);
    }
}