class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int s = 0, e = nums.length-1;
        while (s <= e) {
            if (s == e) {
                ans += nums[s];
                return ans;
            } else {
                StringBuilder sb = new StringBuilder(nums[s++] + "").append(nums[e--]);
                //int concat = Integer.valueOf(String.valueOf(nums[s++]) + String.valueOf(nums[e--]));
                int concat = Integer.valueOf(sb.toString());
                ans += concat;
            }
        }
        return ans;
    }
}