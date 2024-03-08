class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] f = new int[101];
        int max = 0, t = 0;
        for (int i=0; i<nums.length; i++) {
            f[nums[i]]++;
        }
        for (int i=1; i<f.length; i++) {
            if (f[i] == max) {
                t++;
            } else if (f[i] > max) {
                max = f[i];
                t = 1;
            }
        }

        
        return max * t;
    }
}