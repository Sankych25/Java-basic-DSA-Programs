//Union of 2 array using hashset
import java.util.HashSet;
import java.util.Scanner;
public class program076 {
    public static int Union(int arr[],int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        for(int j=0;j<arr2.length;j++){
            set.add(arr2[j]);
        }
        System.out.println("Union of array1 & array2 is : "+set);
        return set.size();
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
        System.out.print("total unique elements are in array1 & array2 : "+Union(arr,arr2));
    }
}
