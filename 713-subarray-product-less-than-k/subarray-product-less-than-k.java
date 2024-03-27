//class Solution {
    /*
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long res = 0;
        int pt1 = 0;
        int pt2 = 0;
        int curr = 1;
        while (pt2 < nums.length) {
            if (nums[pt2] >= k) {
                res += (long)(pt2 - pt1) * (pt2-pt1+1)/2;
                pt1 = ++pt2;
                continue;
            }
            curr *= nums[pt2];
            if (curr < k) {
                pt2++; 
            }
            
            else {
                res += (long)(pt2 - pt1) * (pt2-pt1+1)/2;
                while (pt1 < pt2 && curr >= k) {                   
                    curr /= nums[pt1];                   
                    pt1++;
                }  
                res -= (long)(pt2-pt1) * (pt2-pt1+1)/2;
                pt2++;
            }
        }
        if (curr < k)
            return (int)res + (pt2 - pt1) * (pt2-pt1+1)/2;
        return (int)res;
    }
    */
    class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;        
    }
}
