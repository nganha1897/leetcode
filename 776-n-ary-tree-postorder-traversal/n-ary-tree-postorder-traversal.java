/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    private void dfs(List<Integer> ans, Node cur) {
        if (cur == null) {
            return;
        }
        if (cur.children != null) {
            for (Node child : cur.children) {
                dfs(ans, child);
            }
        }
        ans.add(cur.val);
    }
}