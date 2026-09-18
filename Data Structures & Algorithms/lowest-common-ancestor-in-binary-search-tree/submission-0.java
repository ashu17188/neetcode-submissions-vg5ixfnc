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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return dfs(root, p, q);       
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root ==null || p == null || q == null){
            return null;
        }
        if(p.val < root.val && q.val < root.val){
            return dfs(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            return dfs(root.right, p, q);
        }
        return root;
    }
}
