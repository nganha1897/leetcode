class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int pos = 0, same = 0, cur = 10001;
        for (int i=0; i<n; i++) {
            if (nums[i] != cur) {
                nums[pos++] = nums[i];
                cur = nums[i];
                same = 1;
            } else {
                if (same < 2) {
                    nums[pos++] = nums[i];
                    same++;
                }
            }
            //System.out.println(pos + " " + Arrays.toString(nums));
        }
        return pos;
    }
}