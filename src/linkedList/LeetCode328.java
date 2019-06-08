package linkedList;

public class LeetCode328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode pre = head, cur = head.next;
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = pre.next;
            pre.next = temp;
            pre = pre.next;
            cur = cur.next;
        }

        return head;
    }
}
