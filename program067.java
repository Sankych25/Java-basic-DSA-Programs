//create linkedList and perform basic operation
//addFirst
//addLast
//printList
//deleteFirst,deleteLast
//size,search
//import java.util.*;
public class program067{
    Node head;
    private int size;

    program067(){
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
    //addInMiddle
    // public void addInMiddle(int index,String data){
    //     if(index > size && index < 0){
    //         System.out.println("Invalid Index value");
    //         return;
    //     }
    //     size ++;
    //     Node newNode = new Node(data);
    //     if(head == null || index == 0){
    //         newNode.next = head;
    //         head = newNode;
    //         return;
    //     }
    //     Node currNode = head;
    //     for(int i=1;i<size;i++){
    //         if(i == index){
    //             Node nextNode = currNode.next;
    //             currNode.next = newNode;
    //             newNode.next = nextNode;
    //             break;
    //         }
    //         currNode = currNode.next;
    //     }
    // }
    public static void main(String args[]){
        program067 list = new program067();
        list.addFirst("addFirst");
        list.addLast("addLast");
        list.addLast("printList");
        list.addFirst("deleteFirst");
        list.addLast("deleteLast");
        list.printList();
        //list.addInMiddle(3,"List");
        System.out.println("Size of linkedList is : "+list.getSize());
        list.deleteFirst();
        list.deleteLast();
        list.printList();
    }
}