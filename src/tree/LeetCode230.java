package tree;

import java.util.Stack;

public class LeetCode230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        int cnt = 0;

        while(node != null || !s.empty()) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }

            node = s.pop();
            cnt++;
            if(cnt == k)
                return node.val;

            node = node.right;
        }

        return 0;
    }
}
