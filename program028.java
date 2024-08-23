//write a program for quick sort.
//time complexity O(n^2) 
import java.util.*;
class program028{
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
    public static void quickSort(int arr[],int low,int high){
        if(low < high){
            int pivot = partition(arr,low,high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }
        //return;
    }
    public static int partition(int arr[],int low,int high){
        int pivot = arr[high];
        int i = low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }  
        //i++;
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
    public static void main(String []args){
        System.out.println("Quick Sort");
        int arr[]=getArray();
        //int array[]=
        quickSort(arr,0,arr.length-1);
        System.out.print("Sorted array is : ");
        printArray(arr);
    }
}