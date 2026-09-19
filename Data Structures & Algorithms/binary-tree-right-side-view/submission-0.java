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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode rNode = null;
            int qLen = q.size();

            for (int i = qLen; i > 0; i--) {
                TreeNode node = q.poll();
                if (node != null) {
                    q.add(node.left);
                    q.add(node.right);
                    rNode = node;
                }
            }
            if (rNode != null) {
                res.add(rNode.val);
            }
        }
        return res;
    }
}
