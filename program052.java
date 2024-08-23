//write a code to count nodes of a binary tree
//time complexity O(n)
//import java.util.*;
public class program052{
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
    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNode = countOfNodes(root.left);
        int rightNode = countOfNodes(root.right);
        return leftNode+rightNode+1;
    }
    @SuppressWarnings("static-access")
    public static void main(String args[]){
        int []nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        if(root!=null){
        System.out.println("Total nodes are : "+countOfNodes(root));
        //countOfNodes(root); 
        }else{
        System.out.print("Tree is empty !! ");   
        }
    }
}