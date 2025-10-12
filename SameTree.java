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
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(p);
        stack2.push(q);

        while(!stack1.isEmpty() && !stack2.isEmpty()){
            TreeNode curr1 = stack1.pop();
            TreeNode curr2 = stack2.pop();

            if((curr1 == null && curr2 != null) || (curr2 == null && curr1 != null)){
                return false;
            }

            if(curr1 != null && curr2 != null){
                    if(curr1.val != curr2.val){
                    return false;
                }else{
                    stack1.push(curr1.left);
                    stack1.push(curr1.right);

                    stack2.push(curr2.left);
                    stack2.push(curr2.right);
                }
            }
        }
        return true;
    }
}
