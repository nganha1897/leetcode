class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie root = new Trie();
        for (int a : arr1) {
            root.add(a + "");
        }
        int ans = 0;
        for (int b : arr2) {
            String s = b + "";
            Trie cur = root;
            boolean isFull = true;
            for (int i=0; i<s.length(); i++) {
                int c = s.charAt(i) - '0';
                if (cur.children[c] == null) {
                    ans = Math.max(ans, i);
                    isFull = false;
                    break;
                } 
                cur = cur.children[c];
            }
            if (isFull) {
                ans = Math.max(ans, s.length());
            }
        }

        return ans;
    }
}

class Trie {
    Trie[] children;

    public Trie() {
        children = new Trie[10];
    }

    public void add(String s) {
        Trie root = this;
        for (char cur : s.toCharArray()) {
            int c = cur - '0';
            if (root.children[c] == null) {
                root.children[c] = new Trie();
            }
            root = root.children[c];
        }
    }
}