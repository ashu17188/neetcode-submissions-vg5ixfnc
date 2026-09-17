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
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {p, q});

        while (!stack.empty()) {
            TreeNode node[] = stack.pop();
            TreeNode lNode = node[0];
            TreeNode rNode = node[1];

            if (lNode == null && rNode == null) {
                continue;
            }
            if (lNode == null || rNode == null || lNode.val != rNode.val) {
                return false;
            }
            stack.push(new TreeNode[] {lNode.left, rNode.left});
            stack.push(new TreeNode[] {lNode.right, rNode.right});
        }

        return true;
    }
}
