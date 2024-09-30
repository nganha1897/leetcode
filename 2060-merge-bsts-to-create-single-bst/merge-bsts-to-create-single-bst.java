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
    public TreeNode canMerge(List<TreeNode> trees) {
        Set<Integer> leaves = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        for (TreeNode tree : trees) {
            map.put(tree.val, tree);
            if (tree.left != null) {
                leaves.add(tree.left.val);
            }
            if (tree.right != null) {
                leaves.add(tree.right.val);
            }
        }
        TreeNode root = null;
        for (TreeNode tree : trees) {
            if (!leaves.contains(tree.val)) {
                root = tree;
                break;
            }
        }
        if (root == null) {
            return null;
        }
        
        return buildTree(root, map, Integer.MIN_VALUE, Integer.MAX_VALUE) && map.size() == 1 ? root : null;
    }

    private boolean buildTree(TreeNode root, Map<Integer, TreeNode> map, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (map.containsKey(root.val) && root != map.get(root.val)) {
                TreeNode next = map.get(root.val);
                root.left = next.left;
                root.right = next.right;
                map.remove(root.val);
            }
        }
        return buildTree(root.left, map, min, root.val) && buildTree(root.right, map, root.val, max);
    }
}