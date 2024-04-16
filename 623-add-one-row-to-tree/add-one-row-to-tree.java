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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRt = new TreeNode(val, root, null);
            return newRt;
        }
        dfs(root, val, depth-1);
        return root;
    }
    
    private void dfs(TreeNode cur, int val, int depth) {
        if (cur == null)
            return;
        if (depth == 1) {
            TreeNode l = cur.left, r = cur.right;
            cur.left = new TreeNode(val, l, null);
            cur.right = new TreeNode(val, null, r);
        } else {
            dfs(cur.left, val, depth-1);
            dfs(cur.right, val, depth-1);
        }
    }
}