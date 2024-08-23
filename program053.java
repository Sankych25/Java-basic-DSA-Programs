//write a code to sum of  nodes of a binary tree
//time complexity O(n)
//import java.util.*;
public class program053{
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
    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNode = sumOfNodes(root.left);
        int rightNode = sumOfNodes(root.right);
        return leftNode+rightNode+root.data;
    }
    @SuppressWarnings("static-access")
    public static void main(String args[]){
        int []nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        if(root!=null){
        System.out.println("Total sum of  nodes are : "+sumOfNodes(root));
        //countOfNodes(root); 
        }else{
        System.out.print("Tree is empty !! ");   
        }
    }
}