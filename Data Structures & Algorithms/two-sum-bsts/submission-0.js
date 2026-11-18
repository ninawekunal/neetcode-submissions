/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /**
     * @param {TreeNode} root1
     * @param {TreeNode} root2
     * @param {number} target
     * @return {boolean}
     */
    twoSumBSTs(root1, root2, target) {

        const set = new Set();

        // Any way of determining the smaller tree?

        const dfs = (node) => {
            if (node === null) return;
            set.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }

        dfs(root1);

        const walk = (node) => {
            if (node === null) return false;
            const rem = target - node.val;
            if (set.has(rem)) {
                return true;
            }
            return walk(node.left) || walk(node.right);
        }
        return walk(root2);
    }
}
