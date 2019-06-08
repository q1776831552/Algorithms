package sword;

import java.util.ArrayList;

/*输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。*/

class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
          this.val = val;
      }
    }

public class Solution3 {
    ArrayList list = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if(listNode != null) {
            this.printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;

    }
}

