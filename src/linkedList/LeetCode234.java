package linkedList;

import java.util.Stack;

public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        Stack<Integer> stack = new Stack<>();
        ListNode fast = head, slow = head;
        stack.push(head.val);
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            stack.push(slow.val);
        }

        if (fast.next == null)
            stack.pop();

        while (slow.next != null) {
            if(slow.next.val != stack.pop())
                return false;
            slow = slow.next;
        }

        return true;
    }
}
