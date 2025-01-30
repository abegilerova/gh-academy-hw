class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
    }

 }


public class LinkedListCycle {
    public  boolean hasCycle(ListNode head) {
//        printList(head);
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null){
//            slow = slow.next;
//            fast = fast.next.next;
            if(slow.next == fast.next.next){
                return true;
            }
        }
        return false;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(4);

        node3.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;

        LinkedListCycle cycle = new LinkedListCycle();
        boolean result = cycle.hasCycle(node3);
        System.out.println(result);

    }
}



