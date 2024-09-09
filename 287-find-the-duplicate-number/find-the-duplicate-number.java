class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length, i = 0;
        while (nums[i] != 0) {
            int pos = nums[i];
            nums[i] = 0;
            i = pos;
        }
        return i;
    }
}