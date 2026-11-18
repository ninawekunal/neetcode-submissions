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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean dfs (TreeNode node, int maxVal, int minVal) {
        // DFS tells us if a subTree rooted at that node is a valid BST or not.
        // i.e. node's value should be between the min and maxVal
        if (node == null) return true;
        boolean currentNodeValid = node.val < maxVal && node.val > minVal;
        boolean leftValid = dfs (node.left, node.val, minVal);
        boolean rightValid = dfs (node.right, maxVal, node.val);
        return currentNodeValid && leftValid && rightValid;
    }
}
