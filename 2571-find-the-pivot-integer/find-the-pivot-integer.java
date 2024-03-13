class Solution {
    public int pivotInteger(int n) {
        int[] presum = new int[n+1];
        for (int i=1; i<=n; i++) {
            presum[i] = i + presum[i-1];
        }

        for (int i=1; i<=n; i++) {
            if (presum[i] == presum[n] - presum[i-1])
                return i;
        }

        return -1;
    }
}