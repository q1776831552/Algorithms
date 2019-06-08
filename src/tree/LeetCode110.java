package tree;

public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if (checkDepth(root) == -1)
            return false;
        return true;
    }

    private int checkDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = checkDepth(root.left);
        if(left == -1)
            return -1;

        int right = checkDepth(root.right);
        if (right == -1)
            return -1;

        if(Math.abs(left - right) > 1)
            return -1;

        return Math.max(checkDepth(root.left), checkDepth(root.right)) + 1;
    }
}
