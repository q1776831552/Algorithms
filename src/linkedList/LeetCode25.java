package linkedList;

public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;
        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;
        ListNode cur = head;
        for (int i = 1; cur != null; i++) {
            if(i % k == 0) {
                pre = reverseOneGroup(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    private ListNode reverseOneGroup(ListNode pre, ListNode next) {
        ListNode last = pre.next, cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }

        return last;
    }
}
