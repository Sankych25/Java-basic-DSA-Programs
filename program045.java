//Print all solutions where N queens are safe in N*N chessboard
//Time complexity O(n^n)
//N*N chessboard N queens
//import java.util.*;
public class program045{
/*    public boolean isSafe(int row,int col,char[][]board){
     
        //horizontal check
        for(int j=0;j<board.length;j++){
            if(board[row][j]=='Q'){
                return false;    
            }
        }
        //vertical ckeck
        for(int i=0;i<board.length;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //upperLeft
        int r = row;
        for(int c=col; c>=0 && r>=0; c--,r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        //upperRight
        for(int c=col;c<board.length && r>=0;r--,c++){
            if(board[r][c] == 'Q'){
                return false;
            } 
        }
        //lowerLeft
        for(int c=col;c>=0 && r<board.length;r++,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        //lowerRight
        for(int c=col;c<board.length && r<board.length;r++,c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public void saveBoard(char[][]board,List<List<String>> allBoards){
         //String row = "";
        List<String> newBoard = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder row = new StringBuilder();
            for(int j=0;j<board[0].length;j++){ 
                if(board[i][j] == 'Q'){ 
                    row.append('Q'); 
                }else{
                    row.append('.'); 
                }
            } 
            newBoard.add(row.toString()); 
        } 
        allBoards.add(newBoard); 
    } 
    public void helper(char[][] board,List<List<String>>allBoards,int col){
        if(col == board.length){ 
            saveBoard(board,allBoards); 
            return; 
        } 
        for(int row=0; row<board.length;row++){
            if(isSafe(row,col,board)){ 
                board[row][col]='Q'; 
                helper(board,allBoards,col+1); 
                board[row][col] = '.'; 
            }
        } 
    } 
    public List<List<String>> solveNQueens(int n){ 
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n]; 
        for(int i=0;i<n;i++){ 
            for(int j=0;j<n;j++){ 
                board[i][j] ='.'; 
            } 
        } 
        helper(board,allBoards,0); 
        return allBoards;
    }
    public static void main(String args[]){
        // Scanner sc = new Scanner(System.in);  
        // System.out.print("Enter number of Queens : ");
        // int n = sc.nextInt(); 
        // sc.close(); 
        // solveNQueens(4);
        program045 pro = new program045();
        List<List<String>> result = pro.solveNQueens(4);
        for(List<String> board : result){
           System.out.println("row");
        }
        System.out.println();
    }
*/
    static final int N = 4;
    //print final solution matrix
    static void printSolution(int board[][]){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(" "+board[i][j]+" ");
            }
            System.out.println();
        }
    }  
    //function to check whether the position is safe or not
    static boolean isSafe(int board[][],int row,int col) {
        int i,j;
        for(i=0;i<col;i++){
            if(board[row][i]==1){
                return false;
            }
        }
        for(i=row,j=col;i>=0&&j>=0;i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    } 
    //function that solves the problem using backtracking
    public static boolean solveNqueens(int board[][],int col){
        if(col>=N){
            return true;
        }
        for(int i=0;i<N;i++){
            //if it is safe to place the queen at position i.col-> place it
            if(isSafe(board,i,col)){
                board[i][col]=1;

                if(solveNqueens(board,col+1)){
                    return true;
                }
                //backtrack if the above condition is false 
                board[i][col]=0;
            }
        }
        return false;
    }
    public static void main(String args[]){
        // Scanner sc = new Scanner(System.in);  
        // System.out.print("Enter number of Queens : ");
        // int N = sc.nextInt(); 
        // sc.close(); 
        int board[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        //int board[][] = new int[N][N];
        if(!solveNqueens(board,0)){
            System.out.print("Solution does not exist");
            return;
        }
        printSolution(board);
    }
} 
    