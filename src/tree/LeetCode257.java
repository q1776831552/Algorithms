package tree;

import linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if(root == null)
            return res;

        if (root.left == null && root.right == null)
            res.add(String.valueOf(root.val));

        List<String> leftS = binaryTreePaths(root.left);
        for (String s : leftS) {
            res.add(root.val + "->" + s);
        }

        List<String> rightS = binaryTreePaths(root.right);
        for (String s : rightS) {
            res.add(root.val + "->" + s);
        }

        return res;
    }

    List<String> binaryTreePaths2(TreeNode node) {
        List<String> res = new ArrayList<>();
        findPath(node, new String(), res);
        return res;
    }

    private void findPath(TreeNode node, String str, List<String> res) {
        if(node.left == null && node.right == null)
            res.add(str + String.valueOf(node.val));
        findPath(node.left, str + "->" + String.valueOf(node.val), res);
        findPath(node.right, str + "->" + String.valueOf(node.val), res);
    }
}
