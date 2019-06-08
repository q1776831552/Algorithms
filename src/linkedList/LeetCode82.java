package linkedList;

public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;

        while(pre.next != null) {
            ListNode cur = pre.next;
            while(cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }

            if(cur != pre.next)
                pre.next = cur.next;
            else
                pre = pre.next;
        }

        return dummy.next;
    }
}
