package singlyDoublyLinkedList;

class ListNode1 {
      int val;
      ListNode1 next;

      ListNode1(int val) {
          this.val = val;
          this.next = null;
      }
  }

public class ReverseLinkedList {

    public static ListNode1 reverseList(ListNode1 head) {
        ListNode1 prev = null;
        ListNode1 current = head;
        System.out.println("Original List:");
        printList(head);

        while(current != null){
            ListNode1 nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;

            System.out.println("Reversed List:");
            printList(head);

        }

        return prev;

    }

    public static void printList(ListNode1 head){
        while (head != null){
            System.out.println(head.val + "->");
            head = head.next;
        }

        System.out.println("null");

    }

    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);

        ListNode1 reversedHead = reverseList(head);
        System.out.println("Reversed List:");
        printList(reversedHead);

    }
}
