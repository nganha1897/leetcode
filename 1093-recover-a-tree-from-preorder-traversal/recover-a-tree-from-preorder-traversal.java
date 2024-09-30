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
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode[] levels = new TreeNode[1001];
        int i=0;
        while (i < traversal.length()) {
            int level = 0;
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                level++;
                i++;
            }
            int val = 0;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + traversal.charAt(i) - '0';
                i++;
            }
            TreeNode cur = new TreeNode(val);
            if (level > 0) {
                TreeNode par = levels[level-1];
                if (par.left == null) {
                    par.left = cur;
                } else {
                    par.right = cur;
                }
            }
            levels[level] = cur;
        }
        return levels[0];
    }
}