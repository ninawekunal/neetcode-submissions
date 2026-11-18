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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        // DFS tells us if nodes p's and q's left and right have same children
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        // both p and q are not null
        boolean isLSame = dfs(p.left, q.left);
        boolean isRSame = dfs(p.right, q.right);
        if (!isLSame || !isRSame) return false;
        return p.val == q.val;
    }
}





