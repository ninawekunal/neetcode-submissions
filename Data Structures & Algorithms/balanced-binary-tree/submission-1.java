/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode node) {
        // DFS gives the height difference between left and right subTree.
        if (node == null) return 0; // no height contributed.
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}



