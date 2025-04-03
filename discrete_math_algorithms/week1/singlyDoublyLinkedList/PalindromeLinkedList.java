package singlyDoublyLinkedList;

class ListNode5 {
    int val;
    ListNode5 next;

    public ListNode5(int val){
        this.val = val;
        this.next = null;

    }
}

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode5 head) {

    }
    public static void main(String[] args) {
        ListNode5 head = new ListNode5(1);
        head.next = new ListNode5(2);
        head.next.next = new ListNode5(2);
        head.next.next.next = new ListNode5(1);
    }
}
