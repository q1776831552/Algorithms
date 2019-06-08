package linkedList;

import java.util.*;

class LinkNode {
    public int val;
    public LinkNode next;
    public LinkNode(int _val) {
        val = _val;
    }
}

public class Main {
    public static void main(String[] args) {
        Main solution = new Main();
        LinkNode list = solution.initList();
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int result = solution.findNodeValue(list, k);
        System.out.print(result);
    }

    private int findNodeValue(LinkNode list, int k) {
        LinkNode temp = list;
        int n = 0;
        while(temp != null) {
            temp = temp.next;
            n++;
        }

        int m = n / k;
        LinkNode result = list;
        for(int i = 1; i < m; i++) {
            result = result.next;
        }

        return result.val;
    }

    private LinkNode initList() {
        int val = 0;
        LinkNode head = null, prev = null;
        Scanner scan = new Scanner(System.in);
        while ((val = scan.nextInt()) != 0) {
            LinkNode node = new LinkNode(val);
            if (head == null) {
                head = prev = node;
            } else {
                prev.next = node;
                prev = node;
            }
        }
        return head;
    }
}
