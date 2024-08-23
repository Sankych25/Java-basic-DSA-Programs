//write a program for merge sort.
//time complexity 
import java.util.*;
class program029{
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
    public static void conqure(int arr[],int si,int mid,int ei){
        //si = starting index
        //ei = ending index
        int merged[] = new int[ei-si+1];
        int index1 = si;
        int index2 = mid+1;
        int x = 0;
        while(index1<=mid && index2<=ei){
            if(arr[index1]<=arr[index2]){
                merged[x++]=arr[index1++];
            }else{
                merged[x++]=arr[index2++];
            }
        }
        while(index1<=mid){
            merged[x++]=arr[index1++];
        }
        while(index2<=ei){
            merged[x++]=arr[index2++];
        }
        for(int i=0,j=si;i<merged.length;i++,j++){
            arr[j] = merged[i];
        }
        //return;
    }
    public static void devide(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid = si+(ei-si)/2;
        devide(arr,si,mid);
        devide(arr,mid+1,ei);
        conqure(arr,si,mid,ei);
    }
    public static void main(String []args){
        int arr[]=getArray();
        devide(arr,0,arr.length-1);
        System.out.println("Merge Sort");
        System.out.print("Sorted array is : ");
        printArray(arr);
    }
}