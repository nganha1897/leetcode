class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int[][] ar = new int[n][2];
        for (int i=0; i<n; i++) {
            ar[i][0] = arr[i];
            ar[i][1] = i;
        }
        Arrays.sort(ar, (a,b) -> a[0] - b[0]);
        for (int i=0; i<n; i++) {
            if (i == 0) {
                ans[ar[i][1]] = 1;
            } else {
                if (ar[i][0] == ar[i-1][0]) {
                    ans[ar[i][1]] = ans[ar[i-1][1]];
                } else {
                    ans[ar[i][1]] = ans[ar[i-1][1]] + 1;
                }
            }
        }
        return ans;
    }
}