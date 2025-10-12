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
    public TreeNode invertTree(TreeNode root) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(curr);

        while(!stack.isEmpty()){
            curr = stack.pop();
            if(curr != null){
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;

                stack.push(curr.left);
                stack.push(curr.right);
            }
            
        }

        return root;
    }
}
