class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] rem = new int[100001];
        for (int num : nums) {
            if (num < 0) {
                num = num % value + value;
            }
            rem[num % value]++;
        }

        for (int i = 0; i < nums.length; i++) {
            int mod = i % value;
            if (rem[mod]-- <= 0) {
                return i;
            }
        }
        return nums.length;
    }
}