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

        ListNode5 copiedHead = copyList(head);

        ListNode5 reversedHead = reverseList(copiedHead);
        ListNode5 currentHead = head;
        ListNode5 currentReversedHead = reversedHead;
        while(currentHead != null){
            if(currentHead.val != currentReversedHead.val){
                return false;
            }
            currentHead = currentHead.next;
            currentReversedHead = currentReversedHead.next;
        }

        return true;
    }

    public static ListNode5 reverseList (ListNode5 head){
        ListNode5 prev = null;
        ListNode5 current = head;

        while(current != null ){
            ListNode5 nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    private static ListNode5 copyList(ListNode5 head) {
        ListNode5 newHead = new ListNode5(head.val);
        ListNode5 currentNew = newHead;
        ListNode5 currentOld = head.next;

        while(currentOld != null){
            currentNew.next = new ListNode5(currentOld.val);
            currentNew = currentNew.next;
            currentOld = currentOld.next;

        }

        return newHead;

    }
    public static void main(String[] args) {
        ListNode5 head = new ListNode5(1);
        head.next = new ListNode5(2);
        head.next.next = new ListNode5(2);
        head.next.next.next = new ListNode5(1);

        System.out.println(isPalindrome(head));
    }
}
