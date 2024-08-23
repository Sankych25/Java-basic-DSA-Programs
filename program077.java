//Intersection of 2 arrays using hashset

import java.util.HashSet;
import java.util.Scanner;

public class program077 {
    public static int intersection(int arr1[],int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        System.out.print("Common elements are : ");
        for (int i = 0; i < arr2.length; i++) {
            if(set.contains(arr2[i])){
                count ++;
                System.out.print(arr2[i]+", ");
                set.remove(arr2[i]);
            }
        }
        System.out.println();
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many elements you have to enter in array1 : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        //int nums[] = {1,3,4,2,1,2,4,1,0,5,1,1,1,1};
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element at position "+i+" : ");
            arr[i] = sc.nextInt();
        }
        System.out.print("How many elements you have to enter in array2 : ");
        int m = sc.nextInt();
        int[] arr2 = new int[n];
        //int nums[] = {1,3,4,2,1,2,4,1,0,5,1,1,1,1};
        for (int i = 0; i < m; i++) {
            System.out.print("Enter element at position "+i+" : ");
            arr2[i] = sc.nextInt();
        }
        sc.close();
        System.out.println("total common elements are in array1 & array2 : "+intersection(arr,arr2));
    }
}