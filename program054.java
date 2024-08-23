//write a code to print height of a binary tree
//time complexity O(n)
//import java.util.*;
public class program054{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(idx>=nodes.length ||nodes[idx] == -1){
                return  null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftNode = heightOfTree(root.left);
        int rightNode = heightOfTree(root.right);
        
        int totalHeight = Math.max(leftNode,rightNode)+1;
        return totalHeight;
    }
    @SuppressWarnings("static-access")
    public static void main(String args[]){
        int []nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        if(root!=null){
        System.out.println("Total height of  tree is : "+heightOfTree(root));
        //countOfNodes(root); 
        }else{
        System.out.print("Tree is empty !! ");   
        }
    }
}