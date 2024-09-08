class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int s = 0, e = nums.length-1;
        while (s <= e) {
            if (s == e) {
                ans += nums[s];
                return ans;
            } else {
                int concat = Integer.valueOf(String.valueOf(nums[s++]) + String.valueOf(nums[e--]));
                ans += concat;
            }
        }
        return ans;
    }
}