package tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if(root == null)
            return res;

        List<Integer> list = new ArrayList<>();
        findPath(root, sum, list);
        return res;
    }

    private void findPath(TreeNode root, int sum, List<Integer> list) {
        if(root == null)
            return;
        list.add(root.val);
        if(root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(list));
        }

        findPath(root.left, sum - root.val, list);
        findPath(root.right, sum - root.val, list);
        list.remove(list.size() - 1);
    }
}
