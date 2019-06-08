package tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
        return sumNumbersDFS(root, 0);
    }

    int sumNumbersDFS(TreeNode root, int sum) {
        if(root == null)
            return 0;
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null)
            return sum;
        return sumNumbersDFS(root.left, sum) + sumNumbersDFS(root.right, sum);
    }
}
