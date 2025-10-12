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
    public int goodNodes(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        return goodNodesMax(root, root.val);
    }

    public int goodNodesMax(TreeNode root, int max){
        if(root != null){
            int add = 0;
            if(root.val >= max){
                max = root.val;
                add = 1;
            }

            return add + goodNodesMax(root.left, max) + 
            goodNodesMax(root.right, max);
        }else{
            return 0;
        }
    }
}
