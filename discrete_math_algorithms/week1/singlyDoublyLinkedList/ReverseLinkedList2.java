package singlyDoublyLinkedList;

class ListNode2 {
    int val;
    ListNode2 next;

    public ListNode2(int val){
        this.val = val;
        this.next = null;
    }

}

public class ReverseLinkedList2 {
    public static ListNode2 reverseBetween(ListNode2 head, int left, int right) {
        if(head == null || left == right){
            return head;
        }
        //dummy node
        ListNode2 dummy = new ListNode2(0);
        dummy.next = head;
        ListNode2 prev = dummy;
        //place prev before left
    }

    public static void printList(ListNode2 head){

        while(head != null){
            System.out.println(head.val + "->");
            head = head.next;
        }

    }


    public static void main(String[] args) {
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);

        int left = 2;
        int right = 4;

        ListNode2 reversedHead = reverseBetween(head, left, right);
        System.out.println("Reversed List:");
        printList(reversedHead);

    }
}
