//write a code to reverse a linked List(recursive method)
//
//import java.util.*;
public class program068_1{
    Node head;
    private int size;

    program068_1(){
        this.size = 0;
    }

    class Node{
        String data;
        Node next;
    
        Node(String data){
            this.data = data;
            this.next = null;
            size ++;
        } 
    }
    //add first
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    //add Last
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    //printlist
    public void printList(){
        if(head == null){
            System.out.println("List is Empty !!");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data +" --> ");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }
    //deleteFirst
    public void deleteFirst(){
        if(head == null){
            System.out.println("List is Empty !!");
            return;
        }
        size--;
        head = head.next;
    }
    //deleteLast
    public void deleteLast(){
        if(head == null){
            System.out.println("List is Empty !!");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }
    //size
    public int getSize(){
        return size;
    }
    //reverse list-iterative method
    public void reverseList(){
        if(head == null || head.next == null){
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }
    //reverse list- recursive method
    public Node reverseListRucurssive(Node head){
        //empty node || last node || only one node
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseListRucurssive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public static void main(String args[]){
        program068_1 list = new program068_1();
        list.addFirst("addFirst");
        list.addLast("addLast");
        list.addLast("printList");
        list.addFirst("deleteFirst");
        list.addLast("deleteLast");
        // list.printList();
        //list.addInMiddle(3,"List");
        // System.out.println("Size of linkedList is : "+list.getSize());
        // list.deleteFirst();
        // list.deleteLast();
        list.printList();
        list.head = list.reverseListRucurssive(list.head);
        list.printList();

    }
}