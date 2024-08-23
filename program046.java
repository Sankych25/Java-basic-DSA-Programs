//Create simple binary tree
//time complexity 
//import java.util.*;
public class program046{
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
        public static Node buildTree(int []nodes){
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
    @SuppressWarnings("static-access")
    public static void main(String args[]){
        int []nodes = {2,4,-1,-1,5,-1,1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        if(root!=null){
        System.out.print("Data of root node is : "+root.data);
        }else{
        System.out.print("Tree is empty !! ");   
        }
    }
}