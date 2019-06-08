package linkedList;

public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        for(int i = 0; i < n - m; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }
}
