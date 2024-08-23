//write a program for insertion sort.
//time complexity 
import java.util.*;
class program027{
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int[] getArray(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int n =sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){        
            System.out.print("Enter the element at position "+i+" : ");
            arr[i]=sc.nextInt();
            }
        sc.close();
        return arr;
    }
    public static int[] insertionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print("pass "+(i+1)+" : ");
            int curr=arr[i];
            int j=i-1;
            while(j>=0 && curr<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;
            printArray(arr);
        }
        return arr;
    }
    public static void main(String []args){
        System.out.println("Insrtion Sort");
        int arr[]=getArray();
        int array[]=insertionSort(arr);
        System.out.print("Sorted array is : ");
        printArray(array);
    }
}