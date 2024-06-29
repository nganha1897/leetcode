class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>[] children = new List[n];
        
        for (int i=0; i<n; i++) {
            children[i] = new ArrayList<>();
            ans.add(new ArrayList<>());
        }
        
        for (int[] e : edges) 
            children[e[0]].add(e[1]);
        
        for (int i=0; i<n; i++) {
            //Set<Integer> visited = new HashSet<>();
            Queue<Integer> next = new LinkedList<>();
            next.add(i);
            
            while (!next.isEmpty()) {
                int child = next.poll();
                for (int c : children[child]) {
                    //if (!visited.contains(c)) {
                    if (ans.get(c).size() == 0 || ans.get(c).get(ans.get(c).size()-1) != i) {
                        ans.get(c).add(i);
                        next.offer(c);
                        //visited.add(c);
                    }
                }
            }
        }
        return ans;
    }
    
    /*public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>[] children = new List[n];
        
        for (int i=0; i<n; i++) {
            children[i] = new ArrayList<>();
            ans.add(new ArrayList<>());
        }
        
        for (int[] e : edges) 
            children[e[0]].add(e[1]);
        
        for (int i=0; i<n; i++)
            dfs(i, i, ans, children);
        
        return ans;
    }
    
    private void dfs(int x, int cur, List<List<Integer>> ans, List<Integer>[] children) {
        for (int c : children[cur]) {
            if (ans.get(c).size() == 0 || ans.get(c).get(ans.get(c).size()-1) != x) {
                ans.get(c).add(x);
                dfs(x, c, ans, children);
            }
        }
    }*/
}