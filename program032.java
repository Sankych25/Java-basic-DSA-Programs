// Check if array is sorted or not (Strictly increasing)[recursion]
//Time complexity O(n)
import java.util.*;
public class program032{
    public static boolean isSorted(int arr[],int idx){
        if(idx == arr.length-1){
            return true;
        }
        if(arr[idx] < arr[idx+1]){
            return isSorted(arr,idx+1);
        }else{
            return false;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of arr : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<arr.length;i++){
            System.out.print("Enter element at position "+i+" : ");
            arr[i] = sc.nextInt();
        }
        //System.out.println(isSorted(arr,0));
        if(isSorted(arr,0)){
            System.out.println("Array is sorted!!");
        }else{
            System.out.println("Array is not sorted!!");
        }
        sc.close();
    }
}