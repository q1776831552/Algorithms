package linkedList;

public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;
        while(pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            node1.next = next;
            node2.next = node1;
            pre.next = node2;
            pre = node1;
        }

        return dummy.next;
    }
}
