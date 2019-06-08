package linkedList;

public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode cur = head;
        int n = 0;
        while(cur != null) {
            cur = cur.next;
            n++;
        }

        k %= n;

        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;

        return newHead;
    }
}
