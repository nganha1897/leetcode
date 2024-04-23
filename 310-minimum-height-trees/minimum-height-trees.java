class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i=0; i<n; i++)
                centroids.add(i);
            return centroids;
        }
        
        List<Set<Integer>> neighbors = new ArrayList<>();
        for (int i=0; i<n; i++)
            neighbors.add(new HashSet<>());
        
        for (int[] e : edges) {
            int start = e[0], end = e[1];
            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for (int i=0; i<n; i++)
            if (neighbors.get(i).size() == 1)
                leaves.add(i);
        
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbor = neighbors.get(leaf).iterator().next();
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }
            
            leaves = newLeaves;
        }
        
        return leaves;
    }
}