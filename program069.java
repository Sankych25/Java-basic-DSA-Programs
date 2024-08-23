//write a code to remove n th node from last in  linkedList
//import java.util.*;
/*public class program069{
    public ListNode removeNthNodeFromEnd(ListNode head,int n){
        if(head.next == null){
            return null;
        }
        int size = 0;
        ListNode curr = head;

        while(curr != null){
            curr = curr.next;
            size++;
        }
        if(size == n){
            return head.next;
        }
        int indexToSearch = size-n;
        ListNode prev = head;
        int i = 1;
        while(i<indexToSearch){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }
    public static void main(String args[]){
        //program069 list1 = new program069();
        LinkedList<Integer> list1 = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many element you want to add ? : ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter element at position "+i+" :");
            list1.add(sc.nextInt());
        }
        System.out.println("Your linledlist is : "+list1);
        Node head = removeNthNodeFromEnd(list1.head,n);
        System.out.println("reverse linkedlist is : "+list1);
    }
}*/
public class program069 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthNodeFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0); // Dummy node to handle edge cases
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer to the n+1-th node from the start
        for (int i = 0; i <= n; i++) {
            if (first == null) return head; // If n is larger than the length of the list
            first = first.next;
        }

        // Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // second pointer is now at the node before the one to be removed
        second.next = second.next.next;

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");

        printList(head);

        // Remove 2nd node from end (should remove node with value 4)
        ListNode result = removeNthNodeFromEnd(head, 2);

        System.out.println("List After Removing 2nd Node From End:");
        printList(result);
    }
}
