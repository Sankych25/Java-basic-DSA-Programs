//count total path in maze to move from (0,0) to (n,m)(recursion & backtracking)
//time complexity 
//move only right and downword direction
import java.util.*;
public class program041{
    public static int countPaths(int i,int j,int n, int m){
        if(i==n || j==m){
            return 0;
        }
        if(i==n-1 || j==m-1){
            return 1;
        }
        int downPath = countPaths(i+1,j,n,m);
        int rightpaths = countPaths(i,j+1,n,m);
        return downPath+rightpaths;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Dimension for maze ");
        System.out.print("Enter number of rows : ");
        int n =  sc.nextInt();
        System.out.print("Enter number of columns : ");
        int m = sc.nextInt();
        System.out.print("Total paths are  "+countPaths(0,0,n,m)+" to move from (0,0) to ("+n+","+m+")");
        sc.close();
    }
}