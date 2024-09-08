class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int zero = 0, one = 0;
        long ans = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                one = zero + 1;
                zero = 0;
                ans += one;
            } else {
                zero = one + 1;
                one = 0;
                ans += zero;
            }
        }
        return ans;
    }
}