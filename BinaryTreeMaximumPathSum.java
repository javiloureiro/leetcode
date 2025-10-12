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
    int maxGlobal = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return maxGlobal;
        helper(root);
        return maxGlobal;
    }

    public int helper(TreeNode root){
        int left = 0;
        int right = 0;

        if(root == null) return 0;


        if(root.left != null){
            left = helper(root.left);
        }

        if(root.right != null){
            right = helper(root.right);
        }

        int maxThroughNode = root.val + Math.max(0, left) + Math.max(0, right);
        maxGlobal = Math.max(maxGlobal, maxThroughNode);

        return root.val + Math.max(0, Math.max(left, right));
    }
}
