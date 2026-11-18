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
    public int rob(TreeNode root) {
        int[] robAtRoot = robAt(root);
        return Math.max(robAtRoot[0], robAtRoot[1]);
    }

    int[] robAt(TreeNode node) {
        // [withRootMoney, withoutRootMoney]
        if (node == null) return new int[]{0, 0};

        int[] robLeft = robAt(node.left);
        int[] robRight = robAt(node.right); 
        int robWithRoot = node.val + robLeft[1] + robRight[1];
        int robWithoutRoot = Math.max(robLeft[0], robLeft[1]) + Math.max(robRight[0], robRight[1]);

        return new int[]{robWithRoot, robWithoutRoot};
    }
}








