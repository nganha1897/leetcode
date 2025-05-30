class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[][] dist = new int[n][2];
        
        for (int i=0; i<n; i++)
            Arrays.fill(dist[i], -1);
        
        int n1 = node1, d1 = 0;
        while (true) {
            if (n1 == -1 || visited[n1])
                break;
            visited[n1] = true;
            dist[n1][0] = d1;
            d1++;
            n1 = edges[n1];
        }
        
        Arrays.fill(visited, false);
        int n2 = node2, d2 = 0;
        while (true) {
            if (n2 == -1 || visited[n2])
                break;
            visited[n2] = true;
            dist[n2][1] = d2;
            d2++;
            n2 = edges[n2];
        }
        
        int min = n, ans = -1;
        for (int i=0; i<n; i++) {
            //System.out.println(Arrays.toString(dist[i]));
            if (dist[i][0] != -1 && dist[i][1] != -1) {
                if (min > Math.max(dist[i][0], dist[i][1])) {
                    min = Math.max(dist[i][0], dist[i][1]);
                    ans = i;
                }
            }
                
        }
        
        return ans;
    }
}