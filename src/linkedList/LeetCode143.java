package linkedList;

public class LeetCode143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode pre = null, cur = mid;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur  = next;
        }

        while (head != null && pre != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = pre.next;
            head.next.next = next;
            head = next;
        }
    }
}
