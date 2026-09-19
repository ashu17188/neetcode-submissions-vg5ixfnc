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
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);


    while (!queue.isEmpty()) {
      List<Integer> temp = new ArrayList<>();
      int len = queue.size();
      while (len > 0) {
        TreeNode node = queue.poll();

        if (node != null) {
          temp.add(node.val);
          queue.add(node.left);
          queue.add(node.right);

        }
        len--;

      }
      if (temp.size() > 0) {
        res.add(temp);
      }

    }

    return res;
  }
}
