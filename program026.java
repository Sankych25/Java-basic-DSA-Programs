//write a program for selection sort.
//time complexity O(n^2)
import java.util.*;
class program026{
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
    public static int[] selectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            System.out.print("pass "+(i+1)+" : ");
            int smallest=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[smallest]>arr[j]){
                    smallest = j;
                    // int temp = arr[j];
                    // arr[j] = arr[j+1];
                    // arr[j+1] = temp;
                }
            }        
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
            printArray(arr);
        }
        return arr;
    }
    public static void main(String []args){
        System.out.println("Selection Sort");
        int arr[]=getArray();
        int array[]=selectionSort(arr);
        System.out.print("Sorted array is : ");
        printArray(array);
    }
}