package tree;

public class LeetCode437 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;

        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);

        return res;
    }

    private int findPath(TreeNode node, int sum) {
        if(node == null)
            return 0;

        int res = 0;
        if(sum == node.val)
            res++;

        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);
        return res;
    }
}
