class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, ans = m*n;
        int[][] dir = { {-1, 0}, {0, -1} };
        UnionFind uf = new UnionFind(m * n);
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (grid[r][c] == '0') {
                    ans--;
                    
                } else {
                    int cur = r * n + c;
                    for (int d=0; d<dir.length; d++) {
                        int nextR = r + dir[d][0];
                        int nextC = c + dir[d][1];
                        if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n) {
                            if (grid[nextR][nextC] == '1') {
                                int next = nextR * n + nextC;
                                boolean isAlreadyConnected = uf.connect(cur, next);
                                if (!isAlreadyConnected) {
                                    ans--;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}

class UnionFind {
    int[] root;
    int[] rank;

    public UnionFind(int n) {
        root = new int[n];
        for (int i=0; i<n; i++) {
            root[i] = i;
        }
        rank = new int[n];
    }

    public int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public boolean connect(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return true;
        }
        if (rank[rootA] > rank[rootB]) {
            root[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]) {
            root[rootA] = rootB;
        } else {
            root[rootB] = rootA;
            rank[rootA]++;
        }
        return false;
    }

}