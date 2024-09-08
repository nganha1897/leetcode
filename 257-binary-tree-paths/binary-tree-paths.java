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
        dfs(root, "", ans);
        return ans;
    }

    private void dfs(TreeNode cur, String s, List<String> ans) {
        s += cur.val;
        if (cur.left == null && cur.right == null) {
            ans.add(s);
            return;
        }
        s += "->";
        if (cur.left != null) 
            dfs(cur.left, s, ans);
        if (cur.right != null)
            dfs(cur.right, s, ans);
    }
}