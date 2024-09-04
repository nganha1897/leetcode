class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        // Map<Integer, List<Integer>> map = new HashMap<>();

        // for (int i=0; i<n; i++) {
        //     map.computeIfAbsent(boxes[i], v -> new ArrayList<>()); 
        //     map.get(boxes[i]).add(i);
        // }  

        int[][][] dp = new int[n+1][n+1][n+1];
        for (int j=0; j<n; j++) {
            //List<Integer> colorList = map.get(boxes[j]);
            for (int k=0; k<n; k++) {
                dp[j][j][k] = (k + 1) * (k + 1);
            }          
            for (int i=j-1; i>=0; i--) {
                for (int k=0; k<n; k++) {
                    dp[i][j][k] = dp[i][j-1][0] + (k + 1) * (k + 1);
                    for (int m=i; m<=j; m++) {
                        if (boxes[m] == boxes[j]) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][m][k+1] + dp[m+1][j-1][0]);
                        }
                    }
                }
            }
        }
        return dp[0][n-1][0];
    }
}