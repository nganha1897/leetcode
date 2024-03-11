class Solution {
    public long maximumStrength(int[] a, int k) {
        // int n = nums.length, shift = (int)1e9;
        // long[][][] dp = new long[n+1][k+1][2];
        
        // for (int i=0; i<n; i++) {
        //     nums[i] += shift;
        // }

        // for (int i=n-1; i>=0; i--) {
        //     for (int j=1; j<=Math.min(k, n-i); j++) {
        //         dp[n][j][0] = Long.MIN_VALUE;
        //         dp[i][j][1] = nums[i] * (j % 2 == 0 ? -j : j) + Math.max(dp[i+1][j][1], dp[i+1][j-1][0]);
        //         dp[i][j][0] = Math.max(dp[i][j][1], dp[i+1][j][0]);
        //         System.out.println(i + " " + j + " " + dp[i][j][0]);
        //     }
        // }

        // return dp[0][k][0];

        int n = a.length;
			long[] dp = new long[n+1];
			for(int z = 0;z < k;z++){
				long v = k-z;
				if(z % 2 == 1)v = -v;
				long[] ndp = new long[n+1];
				Arrays.fill(ndp, Long.MIN_VALUE / 3);
				for(int i = 1;i <= n;i++){
					ndp[i] = Math.max(ndp[i], Math.max(ndp[i-1], dp[i-1]) + a[i-1] * v);
				}
				dp = ndp;

				for(int i = 1;i <= n;i++){
					dp[i] = Math.max(dp[i], dp[i-1]);
				}
			}
			return dp[n];
    }
}