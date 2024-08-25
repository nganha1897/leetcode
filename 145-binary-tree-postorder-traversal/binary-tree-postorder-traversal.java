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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> d1 = new ArrayDeque<>();
        Deque<TreeNode> d2 = new ArrayDeque<>();
        d1.offerLast(root);
        while (!d1.isEmpty()) {
            TreeNode cur = d1.pollLast();
            d2.offerLast(cur);
            
            if (cur.left != null) {
                d1.offerLast(cur.left);
            }
            if (cur.right != null) {
                d1.offerLast(cur.right);
            }
        }
        while (!d2.isEmpty()) {
            ans.add(d2.pollLast().val);
        }
        return ans;
    }
}