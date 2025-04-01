package singlyDoublyLinkedList;

class ListNode {
      int val;
      ListNode next;

      ListNode(int val) {
          this.val = val;
          this.next = null;
      }
  }

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        System.out.println("Original List:");
        printList(head);

        while(current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;

            System.out.println("Reversed List:");
            printList(head);

        }

        return prev;

    }

    public static void printList(ListNode head){
        while (head != null){
            System.out.println(head.val + "->");
            head = head.next;
        }

        System.out.println("null");

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversedHead = reverseList(head);
        System.out.println("Reversed List:");
        printList(reversedHead);

    }
}
