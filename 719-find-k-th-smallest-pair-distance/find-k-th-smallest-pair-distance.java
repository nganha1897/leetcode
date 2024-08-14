class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int ans = 0, n = nums.length;
        Arrays.sort(nums);

        int lo = 0, hi = nums[n-1] - nums[0];
        while (lo < hi) {
            int m = lo + (hi-lo)/2;
            int count = 0, left = 0;
            for (int right=0; right<n; right++) {
                while (nums[right] - nums[left] > m)
                    left++;
                count += right - left;
            }
            
            if (count < k)
                lo = m+1;
            else
                hi = m;
            
        }
        return lo;
    }
}