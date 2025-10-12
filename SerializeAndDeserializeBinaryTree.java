/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null,";
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();

            if(curr == null){
                sb.append("null,");
                continue;
            }

            sb.append(curr.val).append(",");

            stack.push(curr.right);
            stack.push(curr.left);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] values = data.split(",");
        int[] index = {0};
        return helper(values, index);
    }

    public TreeNode helper(String[] values, int[] index){

        if(values[index[0]].equals("null")){
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;

        node.left = helper(values , index);
        node.right = helper(values , index);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
