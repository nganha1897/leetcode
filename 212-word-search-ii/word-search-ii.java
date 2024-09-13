class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String w : words) {
            root.add(w);
        }

        List<String> ans = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, ans);
            }
        }
        return ans;
    }

    private void dfs(char[][] board, int r, int c, Trie cur, List<String> ans) {
        if (cur.isWord) {
            ans.add(cur.word);
            cur.isWord = false;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }
        int p = board[r][c] - 'a';
        if (p < 0 || p >= 26 || cur.children[p] == null) {
            return;
        }
        Trie temp = cur.children[p];
        board[r][c] = '#';
        dfs(board, r + 1, c, cur.children[p], ans);
        dfs(board, r, c + 1, cur.children[p], ans);
        dfs(board, r - 1, c, cur.children[p], ans);
        dfs(board, r, c - 1, cur.children[p], ans);
        
        board[r][c] = (char) (p + 'a');
    }
}

class Trie {
    Trie[] children;
    boolean isWord;
    String word;

    public Trie() {
        children = new Trie[26];
    }

    public void add(String s) {
        Trie root = this;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (root.children[c] == null) {
                root.children[c] = new Trie();
            }
            root = root.children[c];
        }
        root.isWord = true;
        root.word = s;
    }
}