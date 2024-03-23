class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int max = 0, n = nums.length;
        for (int i=0; i<n; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] spf = sieve(max+1);
        List<List<Integer>> primeFactors = new ArrayList<>();
        for (int i=0; i<n; i++) {
            List<Integer> curPrimeFactors = getPrimeFactors(nums[i], spf);
            primeFactors.add(curPrimeFactors);
        }

        UnionFind uf = new UnionFind(max+1);
        for (int i=0; i<n; i++) {
            List<Integer> curPrimeFactors = primeFactors.get(i);
            if (curPrimeFactors.size() > 0 && curPrimeFactors.get(0) != nums[i])
                uf.union(curPrimeFactors.get(0), nums[i]);
            for (int j=1; j<curPrimeFactors.size(); j++) {
                uf.union(curPrimeFactors.get(0), curPrimeFactors.get(j));
            }
        }

        for (int i=0; i<n; i++) {
            uf.find(nums[i]);
        }

        int root = uf.root[nums[0]];
        for (int i=1; i<n; i++) {
            if (uf.root[nums[i]] != root || uf.root[nums[i]] == 1) 
                return false;
        }
        return true;
    }
    
    private int[] sieve(int max) { //O(nlog(log(n)))
        int spf[] = new int[max]; //smallest prime factor
        spf[1] = 1;
        for (int i=2; i<max; i++)
            spf[i] = i;
      
        for (int i=4; i<max; i+=2)
            spf[i] = 2;
      
        for (int i=3; i*i<max; i++) {
            if (spf[i] == i) { //i is prime
                for (int j=i*i; j<max; j+=i) {
                    if (spf[j]==j)
                        spf[j] = i;
                }
            }
        }
        return spf;
    }
      
    private List<Integer> getPrimeFactors(int x, int[] spf) {
        List<Integer> primeFactors = new ArrayList<>();
        while (x != 1) {
            primeFactors.add(spf[x]);
            x = x / spf[x];
        }
        return primeFactors;
    }
}

class UnionFind {
    int[] root;
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; 
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}