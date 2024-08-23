//write a code to print diameter of a binary tree
//time complexity O(n)
//import java.util.*;
public class program055_1{
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
    static class TreeInfo{
        int ht,diam;
        TreeInfo(int ht,int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }
    public static TreeInfo diameterOfTree(Node root){
        if(root == null){
            return new TreeInfo(0,0);
        }
        TreeInfo left = diameterOfTree(root.left);
        TreeInfo right = diameterOfTree(root.right);
        int myHeight =Math.max(left.ht,right.ht)+1;

        int diameter1 = left.diam;
        int diameter2 = right.diam;
        int diameter3 = left.ht + right.ht + 1;

        int myDiameter = Math.max(Math.max(diameter1,diameter2),diameter3);
        TreeInfo myInfo = new TreeInfo(myHeight,myDiameter);

        return myInfo;
    }
    
    @SuppressWarnings("static-access")
    public static void main(String args[]){
        int []nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        if(root!=null){
        System.out.println("Total diameter of  tree is : "+diameterOfTree(root).diam);
        //countOfNodes(root); 
        }else{
        System.out.print("Tree is empty !! ");   
        }
    }
}