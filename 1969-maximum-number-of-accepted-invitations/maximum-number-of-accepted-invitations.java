class Solution {
    public int maximumInvitations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] match = new int[n];
        Arrays.fill(match, -1);
        int res = 0;

        for (int boy = 0; boy <m; boy++) {
            boolean[] visited = new boolean[n];
            if (canInvite(boy, grid, match, visited)) {
                res++;
            }
        }

        return res;
    }

    private boolean canInvite(int boy, int[][] grid, int[] match, boolean[] visited) {
        int n = grid[0].length;
        for (int girl = 0; girl < n; girl++) {
            if (grid[boy][girl] == 1 && !visited[girl]) {
                visited[girl] = true;
                if (match[girl] == -1 || canInvite(match[girl], grid, match, visited)) {
                    match[girl] = boy;
                    return true;
                }
            }
        }
        return false;
    }
}