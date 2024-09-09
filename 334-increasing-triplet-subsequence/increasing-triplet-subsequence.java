class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        Integer i = null, j = null;
        for (int k = 0; k<nums.length; k++) {
            if (j == null) {
                j = nums[k];
            } else if (i == null) {
                if (nums[k] > j) {
                    i = j;
                    j = nums[k];
                } else if (nums[k] < j) {
                    j = nums[k];
                }
            } else {
                if (nums[k] > j) {
                    return true;
                } else if (nums[k] < j) {
                    if (nums[k] < i) {
                        i = nums[k];
                    } else if (nums[k] > i) {
                        j = nums[k];
                    }
                }
            }
            //System.out.println(i + " " + j + " " + nums[k]);
        }
        return false;
    }
}