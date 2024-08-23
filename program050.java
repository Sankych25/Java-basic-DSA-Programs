//write a code to print tree data in postorder
//time complexity O(n)
//import java.util.*;
public class program050{
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
    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);        
        postorder(root.right);
        System.out.print(root.data+"-");
    }
    @SuppressWarnings("static-access")
    public static void main(String args[]){
        int []nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        if(root!=null){
        System.out.print("Tree data in postorder : ");
        postorder(root); 
        }else{
        System.out.print("Tree is empty !! ");   
        }
    }
}