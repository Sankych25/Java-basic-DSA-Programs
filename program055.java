//write a code to print diameter of a binary tree
//time complexity O(n^2)
//import java.util.*;
public class program055{
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
    public static int diameterOfTree(Node root){
        if(root == null){
            return 0;
        }
        int diameter1 = diameterOfTree(root.left);
        int diameter2 = diameterOfTree(root.right);
        int diameter3 = heightOfTree(root.left)+heightOfTree(root.right)+1;
        return Math.max(diameter3,Math.max(diameter2,diameter1));
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
        System.out.println("Total diameter of  tree is : "+diameterOfTree(root));
        //countOfNodes(root); 
        }else{
        System.out.print("Tree is empty !! ");   
        }
    }
}