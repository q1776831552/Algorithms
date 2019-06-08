package linkedList;

public class LeetCode147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        while (head != null) {
            ListNode temp = head.next;
            cur = dummy;
            while(cur.next != null && head.val > cur.next.val) {
                cur = cur.next;
            }
            head.next = cur.next;
            cur.next = head;
            head = temp;
        }

        return dummy.next;
    }
}
