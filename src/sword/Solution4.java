package sword;

public class Solution4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length -1, in, 0, in.length - 1);
        return root;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if(startPre > endPre || startIn > endIn)
            return null;

        TreeNode root = new TreeNode(pre[startPre]);
        for(int i = startIn; i <= endIn; i++) {
            if(pre[startPre] == in[i]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i);
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }

        return root;
    }
}
