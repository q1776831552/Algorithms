package tree;

public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.right == null)
                return root.left;

            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }

            cur.left = root.left;
            return root.right;
        }
        return root;

    }
}
