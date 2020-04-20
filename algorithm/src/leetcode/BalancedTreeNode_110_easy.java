package leetcode;

import utils.TreeNode;

/**
 * @author lixinglin
 * @date 2020/4/20 9:18 上午
 * @since jdk 1.8
 */
public class BalancedTreeNode_110_easy {


    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }

        int x = height(root.left) - height(root.right);

        if (Math.abs(x) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

}
