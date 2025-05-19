package singlyDoublyLinkedList;

class ListNode10 {
    int val;
    ListNode10 next ;

    public ListNode10(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycle {

    public static boolean hasCycle(ListNode10 head) {

        ListNode10 slow = head;
        ListNode10 fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode10 node1 = new ListNode10(3);
        ListNode10 node2 = new ListNode10(2);
        ListNode10 node3 = new ListNode10(0);
        ListNode10 node4 = new ListNode10(-4);

        // Link them: 3 -> 2 -> 0 -> -4
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Case 1: Create a cycle (-4 -> 2)
        node4.next = node2;
        System.out.println(hasCycle(node1));
    }
}
