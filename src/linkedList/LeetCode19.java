package linkedList;

public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode before = dummy, after = dummy;
        for (int i = 0 ; i < n + 1; i++) {
            before = before.next;
        }

        while (before != null) {
            before = before.next;
            after = after.next;
        }

        after.next = after.next.next;

        return dummy.next;
    }
}
