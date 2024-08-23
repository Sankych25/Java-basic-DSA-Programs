//Get input from user for 2D array and print it.
import java.util.*;
public class program023{
    public static int[][] get2DArray(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows : ");
        int rows =sc.nextInt();
        System.out.print("Enter the number of columns : ");
        int cols =sc.nextInt();

        int[][]array=new int[rows][cols];

        for(int i=0;i< rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print("Enter element at position ("+i+","+j+"): ");
                array[i][j]=sc.nextInt();
            }
        }
        sc.close();
        return array;
    }
    public static void print2DArray(int[][] array){
        for(int[]row : array){
            for(int element : row){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[][] array= get2DArray();
        System.out.println("The 2D array is : ");
        print2DArray(array);
    }
}