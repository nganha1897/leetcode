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
    public int sumNumbers(TreeNode root) {
        int[] res = new int[1];
        sumNumbers(root, res, 0);
        return res[0];
    }

    private void sumNumbers(TreeNode cur, int[] res, int num) {
        if (cur == null) {
            return;
        }
        num = num * 10 + cur.val;
        if (cur.left == null && cur.right == null)
            res[0] += num;
        sumNumbers(cur.left, res, num);
        sumNumbers(cur.right, res, num);
    }
}