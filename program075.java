//Mejoruty element --> give an array of size n, find all elements that appears more than n/3 times
import java.util.*;
/**
 * program075
 */
public class program075 {
    public static void majorityElements(int nums[]){
        HashMap<Integer,Integer> map = new HashMap<>();

        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        for(int key : map.keySet()){
            if(map.get(key)>(n/3)){
                System.out.println("Majority element is : "+key);
                return;
            }
            System.out.println("No majrity element found in array. ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
             
        System.out.print("How many elements you have to enter : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        //int nums[] = {1,3,4,2,1,2,4,1,0,5,1,1,1,1};
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element at position "+i+" : ");
            nums[i] = sc.nextInt();
        }
        majorityElements(nums);
        sc.close();
    }
}