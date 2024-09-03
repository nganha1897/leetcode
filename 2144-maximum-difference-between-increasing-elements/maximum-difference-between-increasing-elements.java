class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0], ans = -1;

        for (int i=1; i<nums.length; i++) {
            if (nums[i] > min) {
                ans = Math.max(ans, nums[i] - min);
            } else {
                min = Math.min(min, nums[i]);
            }
        }

        return ans;
    }
}