//fund sub-array which sum is equal to k

import java.util.HashMap;
import java.util.Scanner;

/**
 * program079
 */
public class program079 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many element you have to add in array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element at "+i+" position : ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter sum of sub-Array : ");
        int m = sc.nextInt();
        sc.close();

        HashMap<Integer,Integer> map = new HashMap<>();
        int[] arr2 = new int[n];
        map.put(0,1);
        int ans = 0;
        int sum = 0;
        for(int j=0;j<arr.length;j++){
            sum = sum+arr[j];
            
            if(map.containsKey(sum-m)){
                ans += map.get(sum-m);
                
                // for(int x=0;x<arr2.length;x++){
                //     System.out.print(arr2[x]+" ");
                //     arr2[x] = 0;
                // } 
                // System.out.println(); 
            }
            arr2[j] = arr[j];
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
                
            }else{
                map.put(sum,1);
              
            }
        }
        System.out.println("There are total "+ans+" subarray which sum is equal to "+m);
    }
}