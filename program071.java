//write a code to detect loop in linked list.
public class program071 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Function to detect if a linked list has a cycle
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer one step
            fast = fast.next.next;    // Move fast pointer two steps

            if (slow == fast) {
                return true;          // Cycle detected
            }
        }

        return false;                  // No cycle
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main method to test the hasCycle function
    public static void main(String[] args) {
        // Creating a sample linked list with a cycle: 1 -> 2 -> 3 -> 4 -> 2 (cycle)
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle

        boolean result = hasCycle(node1);
        System.out.println("Has Cycle: " + result);

        // Test with a list without a cycle
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(3);

        node5.next = node6;
        node6.next = node7;
        node7.next = null; // No cycle

        result = hasCycle(node5);
        System.out.println("Has Cycle: " + result);
    }
}
