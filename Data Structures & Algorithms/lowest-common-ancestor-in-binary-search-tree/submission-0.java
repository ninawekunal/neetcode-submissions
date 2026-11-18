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
    public TreeNode lowestCommonAncestor(TreeNode current, TreeNode p, TreeNode q) {

        if (current == null || p == null || q == null) return null;
        
        if (current.val > p.val && current.val > q.val) {
            return lowestCommonAncestor(current.left, p, q);
        }
        if (current.val < p.val && current.val < q.val) {
            return lowestCommonAncestor(current.right, p, q);
        }
        // the current is either p or q, or p < current < q
        return current;
    }
}
