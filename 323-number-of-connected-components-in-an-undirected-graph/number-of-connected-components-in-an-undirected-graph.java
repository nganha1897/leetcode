class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        int ans = 0;
        Set<Integer> seen = new HashSet<>();
        for (int i=0; i<n; i++) {
            int curRoot = uf.find(i);
            if (!seen.contains(curRoot)) {
                seen.add(curRoot);
                ans++;
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
        rank = new int[n];
        for (int i=0; i<n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (root[x] == x)
            return x;       
        return root[x] = find(root[x]);
    }

    public boolean union(int a, int b) {
        if (root[a] == root[b])
            return false;
        
        int rootA = find(a);
        int rootB = find(b);

        if (rank[rootA] < rank[rootB]) {
            root[rootB] = rootA;
        } else if (rank[rootB] < rank[rootA]) {
            root[rootA] = rootB;
        } else {
            root[rootA] = rootB;
            rank[rootB]++;
        }
        return true;
    }
}