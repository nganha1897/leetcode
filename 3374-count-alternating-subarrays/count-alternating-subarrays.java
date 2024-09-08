class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long ans = 1, sum = 1;
        for (int i=1; i<nums.length; i++) {
            sum = (nums[i] == nums[i-1] ? 0 : sum) + 1;
            ans += sum;
        }
        return ans;
    }
}