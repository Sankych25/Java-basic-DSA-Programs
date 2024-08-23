//write a code given list is palndrome or not using likedlist
public class program070{

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Function to check if the linked list is a palindrome
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list
        ListNode middle = findMiddle(head);
        ListNode secondHalf = reverse(middle.next);

        // Step 2: Compare the first half and the reversed second half
        ListNode firstHalf = head;
        ListNode secondHalfCopy = secondHalf;
        boolean palindrome = true;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Step 3: Restore the list (optional)
        middle.next = reverse(secondHalfCopy);

        return palindrome;
    }

    // Function to find the middle of the linked list
    private static ListNode findMiddle(ListNode head) {
        ListNode turtle = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
        }
        return turtle;
    }

    // Function to reverse the linked list
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
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

    // Main method to test the isPalindrome function
    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println("Linked List:");
        printList(head);

        boolean result = isPalindrome(head);
        System.out.println("Is Palindrome: " + result);
    }
}
