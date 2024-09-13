// class Solution {
//     public int[] getBiggestThree(int[][] grid) {
//         int m = grid.length, n = grid[0].length;
//         Set<Integer> ans = new HashSet<>();
//         int[][] dir = { { 1, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 } };
//         for (int r = 0; r < m; r++) {
//             for (int c = 0; c < n; c++) {
//                 int y = (m - r - 1) / 2;
//                 int x = Math.min(c, n - c - 1);
//                 int side = Math.min(x, y);
//                 int sum = grid[r][c];
//                 if (side != 0) {
//                     int d = 0;
//                     int curR = r;
//                     int curC = c;
//                     int sideCount = 0;
//                     while (true) {
//                         if (sideCount == side) {
//                             d = (d + 1) % 4;
//                             sideCount = 0;
//                         }
//                         int nextR = curR + dir[d][0];
//                         int nextC = curC + dir[d][1];
//                         if (nextR == r && nextC == c) {
//                             break;
//                         }
//                         sum += grid[nextR][nextC];
//                         curR = nextR;
//                         curC = nextC;
//                         sideCount++;
//                     }
//                 }

//                 ans.add(sum);
                
//             }
//         }
//         int[] res = new int[Math.min(3, ans.size())];
//         List<Integer> list = new ArrayList<>(ans);
//         Collections.sort(list);
//         int p = list.size()-1;
//         int max = Math.min(3, list.size());
//         for (int i=0; i<max; i++) {
//             res[i] = list.get( p--);
//         }
//         return res;
//     }
// }

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        int[][] diagonal = new int[m+1][n+1];
        int[][] fwDiagonal = new int[m+1][n+1]; 
            
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                diagonal[r+1][c+1] = diagonal[r][c] + grid[r][c];
                fwDiagonal[r+1][c] = fwDiagonal[r][c+1] + grid[r][c];
            }
        }
        
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (!set.contains(grid[r][c])) {
                    set.add(grid[r][c]);
                    pq.add(grid[r][c]);
                }
                for (int i=0; r+2*i<m && c-i>=0 && c+i<n; i++) {
                    int upperLeft = fwDiagonal[r+i+1][c-i] - fwDiagonal[r+1][c] + grid[r][c];  
                    int upperRight = diagonal[r+i+1][c+i+1] - diagonal[r+1][c+1] + grid[r][c];
                    int downLeft = diagonal[r+2*i+1][c+1] - diagonal[r+i+1][c-i+1] + grid[r+i][c-i];
                    int downRight = fwDiagonal[r+2*i+1][c] - fwDiagonal[r+i+1][c+i] + grid[r+i][c+i];
                    int sum = upperLeft + upperRight + downLeft + downRight - grid[r][c] - grid[r+i][c-i] - grid[r+2*i][c] - grid[r+i][c+i];
                    if (sum != 0 && !set.contains(sum)) {
                        set.add(sum);
                        pq.add(sum);
                    }
                }
                
                while (pq.size() > 3)
                    pq.poll();
            }
        }
                
        int[] res = new int[pq.size()];    
        while (!pq.isEmpty())
            res[pq.size()-1] = pq.poll();

        return res;
    }
}