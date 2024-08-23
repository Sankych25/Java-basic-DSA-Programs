//write a program for bubble sort.
//time complexity O(n)
import java.util.*;
class program025{
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
    public static int[] bubbleSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            System.out.print("pass "+(i+1)+" : ");
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            printArray(arr);
        }
        return arr;
    }
    public static void main(String []args){
        System.out.println("Bubble Sort");
        int arr[]=getArray();
        int array[]=bubbleSort(arr);
        System.out.print("Sorted array is : ");
        printArray(array);
    }
}