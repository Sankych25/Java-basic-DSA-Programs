//Place tiles of size 1*m in a floor of size n*m(recursion & backtracking)
//time complexity 
import java.util.*;
public class program042{
    public static int placeTiles(int n, int m){
        if(n==m){
            return 2;
        }
        if(n<m){
            return 1;
        }
        int verticalPlacement = placeTiles(n-m,m);
        int horizontalPlacements = placeTiles(n-1,m);
        return verticalPlacement+horizontalPlacements;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Dimension of floor ");
        System.out.print("Total length of floor : ");
        int n =  sc.nextInt();
        System.out.print("Total width of floor : ");
        int m = sc.nextInt();
        System.out.print("Total "+placeTiles(n,m)+" ways are available");
        sc.close();
    }
}