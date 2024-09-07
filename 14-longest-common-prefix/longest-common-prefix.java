class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie root = new Trie();
        for (String s : strs) {
            root.add(s);
        }
        int end = -1, n = strs.length;
        while (true) {
            boolean hasPre = false;
            for (int i=0; i<26; i++) {
                if (root.children[i] != null && root.children[i].count == n) {
                    root = root.children[i];
                    hasPre = true;
                    end++;
                    break;
                } 
            }
            if (!hasPre) {
                break;
            }
        }
        return end == -1 ? "" : strs[0].substring(0, end + 1);
    }
}

class Trie {
    Trie[] children;
    int count;

    public Trie() {
        children = new Trie[26];
    }

    public void add(String s) {
        Trie cur = this;
        for (char c : s.toCharArray()) {
            if (cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new Trie();
            }
            cur = cur.children[c-'a'];
            cur.count++;
        }
    }
}