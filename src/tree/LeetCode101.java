package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);

    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;

        if(left == null || right == null || left.val != right.val)
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if(root == null)
            return true;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);

        while (!q1.isEmpty() && q2.isEmpty()) {
            TreeNode left = q1.poll();
            TreeNode right = q2.poll();
            if(left == null && right == null)
                continue;
            if(left == null || right == null || left.val != right.val)
                return false;

            q1.add(left.left);
            q1.add(left.right);
            q2.add(right.left);
            q2.add(right.right);
        }

        return true;
    }
}
