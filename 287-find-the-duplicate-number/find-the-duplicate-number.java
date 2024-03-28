class Solution {
    public int findDuplicate(int[] nums) {
        int sum = 0, n = nums.length;
        int min = 1, max = n-1;
        while (min < max) {
            int mid = min + (max - min)/2;
            int less = 0;
            for (int i=0; i<n; i++) {
                if (nums[i] <= mid) 
                    less++;
            }
            
            if (less > mid) {
                max = mid;
            } else 
                min = mid + 1;
        } 
        return min;
    }
}