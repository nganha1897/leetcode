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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(TreeNode cur, StringBuilder s, List<String> ans) {
        s.append(cur.val);
        if (cur.left == null && cur.right == null) {
            ans.add(s.toString());
            return;
        }
        s.append("->");
        if (cur.left != null) 
            dfs(cur.left, new StringBuilder(s), ans);
        if (cur.right != null)
            dfs(cur.right, new StringBuilder(s), ans);
    }
}