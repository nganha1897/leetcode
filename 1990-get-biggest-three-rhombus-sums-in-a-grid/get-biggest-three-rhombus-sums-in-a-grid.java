class Solution {
    // public int[] getBiggestThree(int[][] grid) {
    //     int m = grid.length, n = grid[0].length;
    //     Set<Integer> ans = new HashSet<>();
    //     int[][] dir = { { 1, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 } };
    //     for (int r = 0; r < m; r++) {
    //         for (int c = 0; c < n; c++) {
    //             int y = (m - r - 1) / 2;
    //             int x = Math.min(c, n - c - 1);
    //             System.out.println(m + " " + n + " " +r + " " + c + " " + x + " " +y);
    //             int side = Math.min(x, y);
    //             int sum = grid[r][c];
    //             if (side != 0) {
    //                 int d = 0;
    //                 int curR = r;
    //                 int curC = c;
    //                 int sideCount = 0;
    //                 while (true) {
    //                     if (sideCount == side) {
    //                         d = (d + 1) % 4;
    //                         sideCount = 0;
    //                     }
    //                     int nextR = curR + dir[d][0];
    //                     int nextC = curC + dir[d][1];
    //                     if (nextR == r && nextC == c) {
    //                         break;
    //                     }
    //                     sum += grid[nextR][nextC];
    //                     curR = nextR;
    //                     curC = nextC;
    //                     sideCount++;
    //                 }
    //             }

    //             ans.add(sum);
                
    //         }
    //     }
    //     int[] res = new int[Math.min(3, ans.size())];
    //     List<Integer> list = new ArrayList<>(ans);
    //     Collections.sort(list);
    //     int p = list.size()-1;
    //     int max = Math.min(3, list.size());
    //     for (int i=0; i<max; i++) {
    //         res[i] = list.get( p--);
    //     }
    //     return res;
    // }

    public int[] getBiggestThree(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    Set<Integer> ans = new HashSet<>();
    int[][] dir = { { 1, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 } };
    
    for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
            // Always add the single-cell sum
            ans.add(grid[r][c]);
            
            // Calculate the maximum possible side length for rhombus
            int y = (m - r - 1) / 2;
            int x = Math.min(c, n - c - 1);
            int side = Math.min(x, y);
            
            // Process the rhombus for each possible side length
            for (int s = 1; s <= side; s++) {
                int sum = grid[r][c]; // Start with the center point
                int curR = r, curC = c;
                
                // Traverse each of the four sides of the rhombus
                for (int d = 0; d < 4; d++) {
                    for (int i = 0; i < s; i++) {
                        curR += dir[d][0];
                        curC += dir[d][1];
                        
                        // Boundary check
                        if (curR < 0 || curR >= m || curC < 0 || curC >= n) {
                            break;
                        }

                        if (curR == r && curC == c) {
                            break;
                        }
                        
                        sum += grid[curR][curC];
                    }
                }
                
                ans.add(sum); // Add the rhombus sum to the set
            }
        }
    }
    
    // Get the three largest unique sums
    List<Integer> list = new ArrayList<>(ans);
    Collections.sort(list, Collections.reverseOrder());
    
    int[] res = new int[Math.min(3, list.size())];
    for (int i = 0; i < res.length; i++) {
        res[i] = list.get(i);
    }
    
    return res;
}

}