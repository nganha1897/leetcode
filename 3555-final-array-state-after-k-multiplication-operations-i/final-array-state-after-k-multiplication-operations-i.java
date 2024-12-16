class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i=0; i<k; i++) {
            int min = nums[0];
            int pos = 0;
            for (int j=1; j<nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    pos = j;
                }
            }
            nums[pos] *= multiplier;
        }
        return nums;
    }
}