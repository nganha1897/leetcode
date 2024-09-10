class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int start = -1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < 1 || nums[i] > n) {
                nums[i] = 0;
            } else {
                start = i;
            }
        }

        if (start == -1) {
            return 1;
        }

        for (int i=0; i<n; i++) {
            int original = i;
            int cur = nums[i] - 1;
            while (cur >= 0 && nums[cur] >= 0) {
                int next = nums[cur] - 1;
                //System.out.println("next " + next);
                nums[cur] = -1;
                cur = next;
               // System.out.println("cur " + cur);
                
            }
            i = original;
        }
//System.out.println(Arrays.toString(nums));
        for (int i=0; i<n; i++) {
            if (nums[i] >= 0) {
                return i+1;
            }
        }

        return n+1;
    }
}