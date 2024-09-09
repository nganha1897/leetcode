class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int ans = Integer.MIN_VALUE;
        int n = energy.length;
        for (int i=0; i<k; i++) {
            int s=n-i-1;
            int sum = 0;
            while (s>=0) {
                sum += energy[s];
                s -= k;
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}