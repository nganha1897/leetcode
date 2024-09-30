/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "none";
        }
        String ans = root.val + "," + serialize(root.left) + "," + serialize(root.right);
       
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode dummy = new TreeNode(0);
        String[] arr = data.split(",");
         //System.out.println(Arrays.toString(arr));
        List<String> dataList = new LinkedList<>(Arrays.asList(arr));
        return deserialize(dataList);
    }
    private TreeNode deserialize(List<String> arr) {
        if (arr.size() == 0) {
            return null;
        }
        if (arr.get(0).equals("none")) {
            arr.remove(0);
            return null;
        } 
        TreeNode cur = new TreeNode(Integer.valueOf(arr.get(0)));
        arr.remove(0);
        cur.left = deserialize(arr);
        cur.right = deserialize(arr);
        return cur;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));