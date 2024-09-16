class Solution {
    public long minCost(int[] nums, int[] cost) {
        long ans = 0;
        int n = nums.length;
        int[][] arr = new int[n][2];
        long[] preCost = new long[n];

        for (int i=0; i<n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }

        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        for (int i=0; i<n; i++) {
            if (i == 0) {
                preCost[i] = arr[i][1];
            } else {
                preCost[i] = preCost[i-1] + arr[i][1];
            }
        }

        long totalCost  = 0l;
        for (int i=1; i<n; i++) {
            totalCost += 1l * arr[i][1] * (arr[i][0] - arr[0][0]);
        }
        ans = totalCost;

        for (int i=1; i<n; i++) {
            int gap = arr[i][0] - arr[i-1][0];
            totalCost += 1l * preCost[i-1] * gap;
            totalCost -= 1l * (preCost[n-1] - preCost[i-1]) * gap;
            ans = Math.min(ans, totalCost);
        }

        return ans;
    }
}